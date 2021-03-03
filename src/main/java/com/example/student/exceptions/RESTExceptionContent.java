package com.example.student.exceptions;

import org.springframework.http.HttpStatus;

public class RESTExceptionContent {
    private final String message;
    private final HttpStatus httpStatus;

    public RESTExceptionContent(String message, HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
