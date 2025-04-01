package com.dev_bootcamp.service_golden_service.exception;

public class KeyPassDuplicatedException extends RuntimeException{
    public KeyPassDuplicatedException(String message) {
        super(message);
    }
}
