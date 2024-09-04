package com.fcs.bookstore.author;

import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository repository;

    public AuthorServiceImpl(AuthorRepository repository) {
        this.repository = repository;
    }

    @Override
    public Author createAuthor(Author author) {
        return this.repository.save(author);
    }
}
