package com.manpower.platform.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<Map<String, String>> handleEmailAlreadyExists(
            EmailAlreadyExistsException ex) {

        Map<String, String> response = new HashMap<>();

        response.put("error", "EMAIL_ALREADY_EXISTS");
        response.put("message", ex.getMessage());

        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(response);
    }

    @ExceptionHandler(PhoneAlreadyExistsException.class)
    public ResponseEntity<Map<String, String>> handlePhoneAlreadyExists(
            PhoneAlreadyExistsException ex) {

        Map<String, String> response = new HashMap<>();

        response.put("error", "PHONE_ALREADY_EXISTS");
        response.put("message", ex.getMessage());

        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(response);
    }

    @ExceptionHandler(InvalidCredentialsException.class)
public ResponseEntity<Map<String, String>> handleInvalidCredentials(
        InvalidCredentialsException ex) {

    Map<String, String> response = new HashMap<>();

    response.put("error", "INVALID_CREDENTIALS");
    response.put("message", ex.getMessage());

    return ResponseEntity
            .status(HttpStatus.UNAUTHORIZED)
            .body(response);
}
}