package com.bosch.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bosch.example.model.User;
import com.bosch.example.services.UserService;

@RestController
public class UserController {

    @Autowired
    UserService service;

    @PostMapping("/create")
    public String save(@RequestBody User user) {

        return service.save(user);
    }
}
