package com.example.demo.exceptions;

import com.example.demo.exceptions.developerException.DeveloperErrorResponse;
import com.example.demo.exceptions.developerException.DeveloperException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<DeveloperErrorResponse> handleDeveloperException(DeveloperException developerException) {
        DeveloperErrorResponse response = new DeveloperErrorResponse(
                developerException.getStatus().value(), developerException.getMessage(), System.currentTimeMillis()
        );
        log.error(developerException.getMessage());
        return new ResponseEntity<>(response, developerException.getStatus());
    }

    @ExceptionHandler
    public ResponseEntity<DeveloperErrorResponse> handleDeveloperException(Exception exception) {
    DeveloperErrorResponse response = new DeveloperErrorResponse(
            HttpStatus.BAD_REQUEST.value(), exception.getMessage(), System.currentTimeMillis()
    );
    log.error(exception.getMessage());
    return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

}
