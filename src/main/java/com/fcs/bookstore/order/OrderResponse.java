package com.fcs.bookstore.order;

import java.math.BigDecimal;
import java.util.UUID;

public record OrderResponse(
        UUID code,
        Long customerId,
        Long bookId,
        Integer quantity,
        BigDecimal total
) {

    public static OrderResponse from(Order order) {
        return new OrderResponse(order.getCode(), order.getCustomer().getId(), order.getBook().getId(), order.getQuantity(), order.getTotal());
    }
}
