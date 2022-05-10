package com.example.dms.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Map;

public class ValidationExceptionModel {
    private final Map<String, String> errors;
    private final HttpStatus httpStatus;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private final LocalDateTime timestamp;

    public ValidationExceptionModel(final Map<String, String> errors, final HttpStatus httpStatus, final LocalDateTime timestamp) {
        this.errors = errors;
        this.httpStatus = httpStatus;
        this.timestamp = timestamp;
    }

    public Map<String, String> getErrors() {
        return errors;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
