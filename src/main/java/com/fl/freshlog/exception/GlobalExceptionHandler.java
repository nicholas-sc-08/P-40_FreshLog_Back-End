package com.fl.freshlog.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.fl.freshlog.dto.ErrorMessage;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CategoryAlreadyExistsException.class)
    public ResponseEntity<ErrorMessage> handleCategoryExists(CategoryAlreadyExistsException ex) {
        return ResponseEntity.status(409).body(new ErrorMessage(ex.getMessage()));
    }

    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleCategoryNotFOund(CategoryNotFoundException ex) {
        return ResponseEntity.status(404).body(new ErrorMessage(ex.getMessage()));
    }
}
