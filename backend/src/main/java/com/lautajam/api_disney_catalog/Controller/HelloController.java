package com.lautajam.api_disney_catalog.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    
    @GetMapping
    public String HelloController(){
        return "Hello world! This is my project Controller";
    }
}
