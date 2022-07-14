package com.dh.clase35.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptions {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> throwErrorRecursoNoEncontrado(ResourceNotFoundException recursoNoEncontrado){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: "+recursoNoEncontrado.getMessage());
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<String> throwErrorBadRequestTurnos(BadRequestException badRequestException){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(badRequestException.getMessage());
    }
}