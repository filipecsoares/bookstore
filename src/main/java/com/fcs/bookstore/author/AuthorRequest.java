package com.fcs.bookstore.author;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public record AuthorRequest(
        @NotEmpty String name,
        @NotEmpty @Email String email,
        String bio
) {

    public Author toDomain() {
        return new Author(null, this.name(), this.email(), this.bio());
    }
}
