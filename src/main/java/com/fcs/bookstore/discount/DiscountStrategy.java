package com.fcs.bookstore.discount;

import java.math.BigDecimal;

public interface DiscountStrategy {

    BigDecimal apply(BigDecimal price);
}
