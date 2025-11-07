package com.example.demo.controller;
import com.example.demo.entity.Department;
import com.example.demo.entity.Developer;
import com.example.demo.exceptions.developerException.DeveloperValidation;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

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
        developers.put(54454544, new Developer(54454544, "Yavuz", "YAV",
                "05050505050", "yav@yav.com",Department.BILISIM, 3));
        developers.put(46565657, new Developer(46565657, "Ayşe", "AY",
                "02122102101", "ays@ays.com",Department.VERI, 5));
        log.info("2 developers created");
    }

    @GetMapping("/")
    public List<Developer> getDevelopers(){
        return developers.values().stream().toList();
    }

    @GetMapping("/{id}")
    public Developer findDeveloper(@PathVariable int id){
        DeveloperValidation.isIDValid(id);
        DeveloperValidation.isDeveloperNotExist(developers, id);
        return developers.get(id);
    }

    @PostMapping("/")
    public Developer createDeveloper(@RequestBody Developer developer){
        DeveloperValidation.isDeveloperExist(developers, developer.getId());
        developers.put(developer.getId(), developer);
        return developer;
    }

    @PutMapping("/{id}")
    public Developer updateDeveloper(@PathVariable int id, @RequestBody Developer developer){
        DeveloperValidation.isIDValid(id);
        DeveloperValidation.isDeveloperNotExist(developers, id);
        developers.put(id, new Developer(id, developer.getName(), developer.getSurname(), developer.getPhone(),
                developer.getEmail(), developer.getDepartment(), developer.getTermOfOffice()));
        return developer;
    }

    @DeleteMapping("/{id}")
    public Developer deleteDeveloper(@PathVariable int id){
        DeveloperValidation.isIDValid(id);
        DeveloperValidation.isDeveloperNotExist(developers, id);
        developers.remove(id);
        return developers.get(id);
    }
}
