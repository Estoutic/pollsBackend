package com.estoutic.pollsbackend.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("application")
public class TestController {


    @GetMapping("version")
    public String version(){
        return "version is v0.1";
    }
}
