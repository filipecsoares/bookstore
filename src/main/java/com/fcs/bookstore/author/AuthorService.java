package com.fcs.bookstore.author;

public interface AuthorService {

    Author createAuthor(Author author);
    Author getAuthor(Long id);
}
