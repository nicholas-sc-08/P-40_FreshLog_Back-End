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
    public ResponseEntity<ErrorMessage> handleCategoryNotFound(CategoryNotFoundException ex) {
        return ResponseEntity.status(404).body(new ErrorMessage(ex.getMessage()));
    }

    @ExceptionHandler(ProductAlreadyExistsException.class)
    public ResponseEntity<ErrorMessage> handleProductExists(ProductAlreadyExistsException ex) {
        return ResponseEntity.status(409).body(new ErrorMessage(ex.getMessage()));
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleProductNotFound(ProductNotFoundException ex) {
        return ResponseEntity.status(404).body(new ErrorMessage(ex.getMessage()));
    }

    @ExceptionHandler(BatchAlreadyExistsException.class)
    public ResponseEntity<ErrorMessage> handleBatchExists(BatchAlreadyExistsException ex) {
        return ResponseEntity.status(409).body(new ErrorMessage(ex.getMessage()));
    }

    @ExceptionHandler(BatchNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleBatchNotFound(BatchNotFoundException ex) {
        return ResponseEntity.status(404).body(new ErrorMessage(ex.getMessage()));
    }
}
