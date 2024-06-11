package com.bosch.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import com.bosch.example.dto.ResultImaginaryExp;
import com.bosch.example.services.ImaginaryExpService;


public class ImaginaryExpControler {
    @Autowired
    ImaginaryExpService serv;

    @GetMapping("imaexp/")
    public ResultImaginaryExp validate(Double A, Double b){
        return serv.calculate(A, b);
    } 
}
