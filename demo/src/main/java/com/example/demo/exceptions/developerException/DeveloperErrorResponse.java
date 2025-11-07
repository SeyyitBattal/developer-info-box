package com.example.demo.exceptions.developerException;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeveloperErrorResponse {
private int status;
private String message;
private long timestamp;
}
