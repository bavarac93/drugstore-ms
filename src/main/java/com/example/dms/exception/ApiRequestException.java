package com.example.dms.exception;

public class ApiRequestException extends RuntimeException{
    public ApiRequestException(final String message) {
        super(message);
    }
}
