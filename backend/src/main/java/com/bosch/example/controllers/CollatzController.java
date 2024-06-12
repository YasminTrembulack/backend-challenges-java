package com.bosch.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bosch.example.dto.CollatzResult;
import com.bosch.example.services.CollatzService;

@RestController
public class CollatzController {
    @Autowired
    CollatzService serv;
    
    @GetMapping("collatz")
    public CollatzResult validate(int current, int step){
        return serv.calculate(current, step);
    } 
    
}





