package com.example.demo.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/developers")
public class DeveloperController {

    @GetMapping("/")
    public String hiController() {
        System.out.println("Hello World!");
        return "hi developer";
    }
}
