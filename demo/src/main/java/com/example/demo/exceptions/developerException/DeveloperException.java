package com.example.demo.exceptions.developerException;


import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class DeveloperException extends RuntimeException {
private HttpStatus status;

public DeveloperException(String message, HttpStatus status) {
    super(message);
    this.status = status;
}

}
