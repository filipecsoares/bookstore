package com.fcs.bookstore.order;

import com.fcs.bookstore.book.Book;
import com.fcs.bookstore.customer.Customer;
import jakarta.validation.constraints.NotNull;

public record OrderRequest(
        @NotNull Long customerId,
        @NotNull Long bookId,
        @NotNull Integer quantity
) {

    public Order toOrder() {
        return new Order(null, null, new Customer(customerId), new Book(bookId), quantity, null, null);
    }
}
