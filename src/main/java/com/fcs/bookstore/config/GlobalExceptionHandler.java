package com.fcs.bookstore.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleIllegalArgException(IllegalArgumentException illegalArgumentException) {
        logger.error(illegalArgumentException.getMessage());
        return new ResponseEntity<>(new ErrorResponse(illegalArgumentException.getMessage()), HttpStatus.NOT_FOUND);
    }
}
