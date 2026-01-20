package com.fl.freshlog.exception;

public class BatchAlreadyExistsException extends RuntimeException {
    public BatchAlreadyExistsException(String message) {
        super(message);
    }
}
