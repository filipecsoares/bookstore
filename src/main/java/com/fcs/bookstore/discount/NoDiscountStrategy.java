package com.fcs.bookstore.discount;

import java.math.BigDecimal;

public class NoDiscountStrategy implements DiscountStrategy {

    @Override
    public BigDecimal apply(BigDecimal price) {
        return price;
    }
}
