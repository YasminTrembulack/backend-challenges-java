package com.bosch.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bosch.example.dto.ImaginaryExpResult;
import com.bosch.example.services.ImaginaryExpService;

@RestController
public class ImaginaryExpController {
    @Autowired
    ImaginaryExpService serv;

    @GetMapping("imaexp")
    public ImaginaryExpResult validate(Double A, Double b){
        return serv.calculate(A, b);
    } 
}
