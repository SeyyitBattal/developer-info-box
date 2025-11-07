package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Developer {
    private String id;
    private String name;
    private String surname;
    private String phone;
    private String email;
    private Department department;
    private int termOfOffice;
}
