package com.tuana9a.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Arrays;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler
    public ResponseEntity<String> exception(Exception e) {
        return ResponseEntity.status(500).body("Exception: " + e.getMessage());
    }
}
