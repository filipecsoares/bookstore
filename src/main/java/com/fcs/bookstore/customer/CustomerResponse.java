package com.fcs.bookstore.customer;

public record CustomerResponse(
        Long id,
        String name,
        String email
) {

        public static CustomerResponse fromDomain(Customer customer) {
            return new CustomerResponse(customer.getId(), customer.getName(), customer.getEmail());
        }
}
