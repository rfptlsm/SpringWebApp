package com.springwebapp.webapp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionsControllerAdvice {
    @ExceptionHandler
    public ResponseEntity<?>handleREsResponseNotFoundException(ResourceNotFoundException e){
        StoreError storeError = new StoreError(HttpStatus.NOT_FOUND.value(), e.getMessage());
        return new ResponseEntity<>(storeError, HttpStatus.NOT_FOUND);
    }
    
}
