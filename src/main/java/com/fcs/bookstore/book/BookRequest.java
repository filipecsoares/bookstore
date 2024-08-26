package com.fcs.bookstore.book;

import com.fcs.bookstore.author.Author;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record BookRequest(
        @NotEmpty String title,
        @NotNull Long authorId,
        @NotEmpty String isbn,
        Integer year,
        Integer pages
) {

        public Book toDomain() {
            return new Book(null, this.title(), new Author(this.authorId(), null, null, null), this.isbn(), this.year(), this.pages());
        }
}
