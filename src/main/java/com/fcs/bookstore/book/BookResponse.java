package com.fcs.bookstore.book;

public record BookResponse(
        Long id,
        String title,
        String author,
        String isbn,
        Integer year,
        Integer pages
) {

    public static BookResponse fromDomain(Book book) {
        return new BookResponse(
                book.getId(),
                book.getTitle(),
                book.getAuthor().getName(),
                book.getIsbn(),
                book.getReleasedYear(),
                book.getPages()
        );
    }
}
