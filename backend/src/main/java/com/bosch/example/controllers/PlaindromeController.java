package com.bosch.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bosch.example.dto.PalindromeResult;
import com.bosch.example.services.PalindromeService;


@RestController
public class PlaindromeController {

    @Autowired
    PalindromeService plain;

    @GetMapping("reverse/{word}")
    public PalindromeResult validate(@PathVariable String word){
        return plain.isPlaindrome(word);
    } 
}



