package com.fcs.bookstore.customer;

import jakarta.persistence.*;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String email;
    private String address;
    private String cep;
    @Enumerated(EnumType.STRING)
    private CustomerType type;

    public Customer() {
    }

    public Customer(Long id) {
        this.id = id;
    }

    public Customer(Long id, String name, String email, String address, String cep, CustomerType type) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.cep = cep;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getCep() {
        return cep;
    }

    public CustomerType getType() {
        return type;
    }
}
