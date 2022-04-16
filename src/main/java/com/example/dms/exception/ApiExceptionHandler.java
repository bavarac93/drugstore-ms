package com.example.dms.exception;

import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ApiExceptionHandler {

    public static final HttpStatus BAD_REQUEST = HttpStatus.BAD_REQUEST;

    @ExceptionHandler(value = ApiRequestException.class)
    public ResponseEntity<Object> exceptionHandler (final @NotNull ApiRequestException e) {
        final ApiExceptionResponse apiExceptionResponse = new ApiExceptionResponse(
                e.getMessage(),
                BAD_REQUEST,
                LocalDateTime.now()
        );
        return new ResponseEntity<>(apiExceptionResponse, BAD_REQUEST);
    }
}
