package com.fcs.bookstore.author;

public record AuthorResponse(
        Long id,
        String name,
        String email,
        String bio
) {

    public static AuthorResponse fromDomain(Author author) {
        return new AuthorResponse(author.getId(), author.getName(), author.getEmail(), author.getBio());
    }
}
