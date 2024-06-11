package com.bosch.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bosch.example.dto.ReverseResult;
import com.bosch.example.services.Plaindrome;


@RestController
public class PlaindromeController {

    @Autowired
    Plaindrome plain;

    @GetMapping("reverse/{word}")
    public ReverseResult validate(@PathVariable String word){
        System.out.println(plain.isPlaindrome(word));
        return plain.isPlaindrome(word);
    } 
}



