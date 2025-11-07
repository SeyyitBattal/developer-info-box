package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Developer {
    private long id;
    private String name;
    private String surname;
    private long phone;
    private String email;
    private Department department;
}
