
package com.example.student.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class CourseNotFoundException extends RuntimeException {

    public CourseNotFoundException(String message) {
        super(message);
    }

    public CourseNotFoundException(String message, Throwable throwable) {
        super(message, throwable);
    }

}