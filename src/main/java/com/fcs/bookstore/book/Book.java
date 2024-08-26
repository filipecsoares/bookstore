package com.fcs.bookstore.book;

import com.fcs.bookstore.author.Author;
import jakarta.persistence.*;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String title;
    @ManyToOne
    private Author author;
    private String isbn;
    private Integer releasedYear;
    private Integer pages;

    public Book() {
    }

    public Book(Long id, String title, Author author, String isbn, Integer releasedYear, Integer pages) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.releasedYear = releasedYear;
        this.pages = pages;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public Integer getReleasedYear() {
        return releasedYear;
    }

    public Integer getPages() {
        return pages;
    }
}
