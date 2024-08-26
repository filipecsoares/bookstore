package com.fcs.bookstore.discount;

import com.fcs.bookstore.customer.CustomerType;

public class GetDiscountStrategy {

    private GetDiscountStrategy() {
    }

    public static DiscountStrategy getBy(CustomerType type) {
        if (type == null) {
            return new NoDiscountStrategy();
        }
        return switch (type) {
            case PREMIUM -> new PremiumDiscountStrategy();
            case VIP -> new VipDiscountStrategy();
            default -> new NoDiscountStrategy();
        };
    }
}
