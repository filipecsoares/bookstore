package com.fcs.bookstore.order;

import com.fcs.bookstore.book.BookService;
import com.fcs.bookstore.customer.CustomerService;
import com.fcs.bookstore.discount.GetDiscountStrategy;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository repository;
    private final BookService bookService;
    private final CustomerService customerService;

    public OrderServiceImpl(OrderRepository repository, BookService bookService, CustomerService customerService) {
        this.repository = repository;
        this.bookService = bookService;
        this.customerService = customerService;
    }

    @Override
    public Order placeOrder(Order order) {
        var book = bookService.getBook(order.getBook().getId());
        var customer = customerService.getCustomer(order.getCustomer().getId());
        var total = getTotal(book.getPrice(), order.getQuantity());
        total = GetDiscountStrategy.getBy(customer.getType()).apply(total);
        var code = UUID.randomUUID();
        return repository.save(new Order(null, code, customer, book, order.getQuantity(), total, OrderStatus.PENDING));
    }

    private BigDecimal getTotal(BigDecimal price, Integer quantity) {
        return price.multiply(BigDecimal.valueOf(quantity));
    }
}
