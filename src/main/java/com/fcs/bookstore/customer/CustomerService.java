package com.fcs.bookstore.customer;

import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public Customer createCustomer(Customer customer) {
        return this.repository.save(customer);
    }

    public Customer getCustomer(final Long id) {
        return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Customer not found."));
    }
}
