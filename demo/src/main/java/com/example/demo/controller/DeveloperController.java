package com.example.demo.controller;
import com.example.demo.entity.Department;
import com.example.demo.entity.Developer;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/developers")
@Slf4j
public class DeveloperController {
    private Map<Integer, Developer> developers;

    @PostConstruct
    public void init(){
        developers = new HashMap<>();
        developers.put(1, new Developer("4546R4VG", "Yavuz", "YAV",
                "05050505050", "yav@yav.com",Department.BILISIM, 3));
    }

    @GetMapping("/")
    public List<Developer> getDevelopers(){
        return developers.values().stream().toList();
    }
}
