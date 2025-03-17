package com.documentmanagement.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class DocumentControllerAdvice {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ApiError handleBadRequest(BadRequestException exception) {
        return ApiError.builder()
                .message(exception.getMessage())
                .time(LocalDateTime.now())
                .errorCode(500)
                .build();
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    ApiError handleNotFound(ResourceNotFoundException exception) {
        return ApiError.builder()
                .message(exception.getMessage())
                .time(LocalDateTime.now())
                .errorCode(404)
                .build();
    }

}
