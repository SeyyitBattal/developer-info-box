package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
public class Developer {
    private int id;
    private String name;
    private String surname;
    private String phone;
    private String email;
    private Department department;
    private int termOfOffice;
}
