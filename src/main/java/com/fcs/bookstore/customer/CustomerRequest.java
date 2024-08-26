package com.fcs.bookstore.customer;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public record CustomerRequest(
        @NotEmpty String name,
        @NotEmpty @Email String email
) {

    public Customer toDomain() {
        return new Customer(null, this.name(), this.email(), null, null, null);
    }
}
