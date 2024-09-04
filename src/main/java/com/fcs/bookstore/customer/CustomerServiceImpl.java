package com.fcs.bookstore.customer;

import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;

    public CustomerServiceImpl(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return this.repository.save(customer);
    }

    @Override
    public Customer getCustomer(final Long id) {
        return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Customer not found."));
    }
}
