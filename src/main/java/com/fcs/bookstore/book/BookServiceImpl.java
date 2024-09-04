package com.fcs.bookstore.book;

import com.fcs.bookstore.author.AuthorRepository;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository repository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository repository, AuthorRepository authorRepository) {
        this.repository = repository;
        this.authorRepository = authorRepository;
    }

    @Override
    public Book createBook(Book book) {
        if (!this.authorRepository.existsById(book.getAuthor().getId())) {
            throw new IllegalArgumentException("Author not found");
        }
        return this.repository.save(book);
    }

    @Override
    public Book getBook(final Long id) {
        return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Book not found."));
    }
}
