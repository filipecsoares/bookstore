package com.fcs.bookstore.author;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/authors")
public class AuthorController {

    private final AuthorService service;

    public AuthorController(AuthorService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<AuthorResponse> createBook(@RequestBody @Valid AuthorRequest request) {
        return new ResponseEntity<>(AuthorResponse.fromDomain(this.service.createAuthor(request.toDomain())), HttpStatus.CREATED);
    }
}
