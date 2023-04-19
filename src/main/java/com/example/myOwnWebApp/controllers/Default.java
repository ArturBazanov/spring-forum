package com.example.myOwnWebApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Default {

    @GetMapping("/hello")
    public String helloPage(){
        return "hello";
    }
}
