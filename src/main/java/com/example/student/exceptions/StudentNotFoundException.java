package com.example.student.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus
public class StudentNotFoundException extends RuntimeException{

        public StudentNotFoundException(String message) {
            super(message);
        }

        public StudentNotFoundException(String message, Throwable throwable) {
            super(message, throwable);
        }
    }


