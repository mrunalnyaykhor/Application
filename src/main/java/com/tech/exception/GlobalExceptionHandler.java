package com.tech.exception;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(EmployeeNotFoundException exception,
                                                                        WebRequest webRequest)
    {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), List.of(exception.getMessage()),
                webRequest.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, WebRequest request) {
        List<String> collect = ex.getBindingResult().getAllErrors().stream().filter(Objects::nonNull)
                .map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.toList());

        ErrorDetails errorDetails = new ErrorDetails(new Date(), collect,
                "Invalid Request");

        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDetails);
    }
}
