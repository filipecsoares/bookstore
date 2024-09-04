package com.fcs.bookstore.book;

public interface BookService {

    Book createBook(Book book);

    Book getBook(final Long id);
}
