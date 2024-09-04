package com.fcs.bookstore.customer;

public interface CustomerService {

    Customer createCustomer(Customer customer);

    Customer getCustomer(final Long id);
}
