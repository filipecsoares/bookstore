package com.fcs.bookstore.discount;

import java.math.BigDecimal;

public class VipDiscountStrategy implements DiscountStrategy {

    @Override
    public BigDecimal apply(BigDecimal price) {
        // 20% discount
        return price.multiply(BigDecimal.valueOf(0.8));
    }
}
