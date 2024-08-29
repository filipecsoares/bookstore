package com.fcs.bookstore.order;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import com.fcs.bookstore.author.Author;
import com.fcs.bookstore.book.Book;
import com.fcs.bookstore.book.BookService;
import com.fcs.bookstore.customer.Customer;
import com.fcs.bookstore.customer.CustomerService;
import com.fcs.bookstore.customer.CustomerType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;

class OrderServiceTest {

    private OrderRepository repository;
    private BookService bookService;
    private CustomerService customerService;
    private OrderService orderService;
    private Book book;
    private Customer customer;

    @BeforeEach
    void setUp() {
        repository = mock(OrderRepository.class);
        bookService = mock(BookService.class);
        customerService = mock(CustomerService.class);
        orderService = new OrderService(repository, bookService, customerService);
        book = new Book(1L, "Test Book", new Author(), "", 100, 100, BigDecimal.TEN);
        customer = new Customer(1L, "Test Customer", "test@test.com", "", "", CustomerType.REGULAR);
    }

    @Test
    void placeOrderSuccessfully() {
        var order = new Order(null, null, customer, book, 2, null, OrderStatus.PENDING);

        when(bookService.getBook(book.getId())).thenReturn(book);
        when(customerService.getCustomer(customer.getId())).thenReturn(customer);
        when(repository.save(any(Order.class))).thenAnswer(invocation -> invocation.getArgument(0));

        var result = orderService.placeOrder(order);

        assertNotNull(result.getCode());
        assertEquals(OrderStatus.PENDING, result.getStatus());
        assertEquals(BigDecimal.valueOf(20), result.getTotal());
    }

    @Test
    void placeOrderBookNotFound() {
        var order = new Order(null, null, customer, book, 2, null, OrderStatus.PENDING);

        when(bookService.getBook(order.getBook().getId())).thenThrow(new IllegalArgumentException("Book not found."));

        assertThrows(IllegalArgumentException.class, () -> orderService.placeOrder(order));
    }

    @Test
    void placeOrderCustomerNotFound() {
        var order = new Order(null, null, customer, book, 2, null, OrderStatus.PENDING);

        when(bookService.getBook(book.getId())).thenReturn(book);
        when(customerService.getCustomer(order.getCustomer().getId())).thenThrow(new IllegalArgumentException("Customer not found."));

        assertThrows(IllegalArgumentException.class, () -> orderService.placeOrder(order));
    }

    @Test
    void placeOrderWithDiscount() {
        var customerPremium = new Customer(1L, "Test Customer", "test@test.com", "", "", CustomerType.PREMIUM);
        var order = new Order(null, null, customerPremium, book, 2, null, OrderStatus.PENDING);

        when(bookService.getBook(book.getId())).thenReturn(book);
        when(customerService.getCustomer(customerPremium.getId())).thenReturn(customerPremium);
        when(repository.save(any(Order.class))).thenAnswer(invocation -> invocation.getArgument(0));

        var result = orderService.placeOrder(order);

        assertNotNull(result.getCode());
        assertEquals(OrderStatus.PENDING, result.getStatus());
        assertTrue(result.getTotal().compareTo(BigDecimal.valueOf(20)) < 0);
    }
}
