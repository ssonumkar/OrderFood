package com.orderfood.OrderFood.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        // Log the exception (use a logging framework in a real application)
        System.err.println("Unhandled exception: " + ex.getMessage());

        // Return a generic error response
        return new ResponseEntity<>("An unexpected error occurred. Please try again later.", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ExceptionResponse> handleInputBodyException(Exception ex) {
        // Log the exception (use a logging framework in a real application)
        System.err.println("Unhandled exception: " + ex.getMessage());
        ExceptionResponse response = new ExceptionResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Invalid Input");
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}