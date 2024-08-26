package com.fcs.bookstore.discount;

import java.math.BigDecimal;

public class PremiumDiscountStrategy implements DiscountStrategy {

    @Override
    public BigDecimal apply(BigDecimal price) {
        // 10% discount
        return price.multiply(BigDecimal.valueOf(0.9));
    }
}
