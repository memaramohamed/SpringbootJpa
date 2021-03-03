package com.example.student.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RESTExceptionHandler {

    @ExceptionHandler(value = {StudentNotFoundException.class})
    public ResponseEntity<Object> handleStudentNotFoundException(StudentNotFoundException e) {
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        RESTExceptionContent restException = new RESTExceptionContent(e.getMessage(), badRequest);
        return new ResponseEntity<>(restException, badRequest);
    }

    @ExceptionHandler(value = {CourseNotFoundException.class})
    public ResponseEntity<Object> handleCourseNotFoundException(CourseNotFoundException e) {
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        RESTExceptionContent restException = new RESTExceptionContent(e.getMessage(), badRequest);
        return new ResponseEntity<>(restException, badRequest);
    }
}
