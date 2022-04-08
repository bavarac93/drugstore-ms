package com.example.dms.exception;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class ApiExceptionResponse {
    private final String message;
    private final HttpStatus httpStatus;
    private final LocalDateTime timestamp;

    public ApiExceptionResponse(final String message, final HttpStatus httpStatus, final LocalDateTime timestamp) {
        this.message = message;
        this.httpStatus = httpStatus;
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
