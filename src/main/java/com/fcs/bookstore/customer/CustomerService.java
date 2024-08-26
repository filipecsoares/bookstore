package com.fcs.bookstore.customer;

import com.fcs.bookstore.author.Author;
import com.fcs.bookstore.author.AuthorRepository;
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
}
