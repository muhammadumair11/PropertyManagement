package com.umair.PropertyManagement.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.security.SignatureException;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UserAlreadyExistsException.class)
    protected ResponseEntity<Object> handleUserAlreadyExistsException(UserAlreadyExistsException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
    @ExceptionHandler(UsernameNotFoundException.class)
    protected ResponseEntity<Object> handleUsernameNotFoundException(UsernameNotFoundException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
    @ExceptionHandler(SignatureException.class)
    protected ResponseEntity<Object> handleTokenExpiredException(SignatureException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
