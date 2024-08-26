package com.fcs.bookstore.book;

import com.fcs.bookstore.author.AuthorRepository;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private final BookRepository repository;
    private final AuthorRepository authorRepository;

    public BookService(BookRepository repository, AuthorRepository authorRepository) {
        this.repository = repository;
        this.authorRepository = authorRepository;
    }

    public Book createBook(Book book) {
        if (!this.authorRepository.existsById(book.getAuthor().getId())) {
            throw new IllegalArgumentException("Author not found");
        }
        return this.repository.save(book);
    }
}
