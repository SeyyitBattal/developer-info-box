package com.example.demo.exceptions.developerException;


import com.example.demo.entity.Developer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

import java.util.Map;

@Slf4j
public class DeveloperValidation {

    public static void isIDValid(int id){
        if(id <= 0){
            throw new DeveloperException("Your given id: " + id + " isn't valid!", HttpStatus.BAD_REQUEST);
        }
    }

    public static void isDeveloperExist(Map<Integer, Developer> developers, int id){
        if(developers.containsKey(id)){
            throw new DeveloperException("Your given id: " + id + " is already exist!", HttpStatus.BAD_REQUEST);
        }
    }

    public static void isDeveloperNotExist(Map<Integer, Developer> developers, int id){
        if(!developers.containsKey(id)){
            throw new DeveloperException("Your given id: " + id + " is not exist!", HttpStatus.NOT_FOUND);
        }
    }
}
