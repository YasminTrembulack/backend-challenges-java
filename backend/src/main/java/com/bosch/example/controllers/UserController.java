package com.bosch.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bosch.example.dto.PasswordUpdate;
import com.bosch.example.model.User;
import com.bosch.example.services.EmailValidatorService;
import com.bosch.example.services.PasswordValidatorService;
import com.bosch.example.services.UserService;


@RestController
public class UserController {

    @Autowired
    UserService service;

    @Autowired
    EmailValidatorService emailService;

    @Autowired
    PasswordValidatorService passService;

    @PostMapping("/create")
    public String save(@RequestBody User user) {

        if (user.getUsername() == null || user.getUsername().length() < 4) {
            return "Username is too short.";
        }
        
        if (!emailService.validate(user.getEmail())) {
            return "Email is too short or invalid.";
        }

        if (service.loginByUsername(user.getUsername()) != null) {
            return "The username already exists.";
        }

        if (service.loginByEmail(user.getEmail()) != null) {
            return "The email already exists.";
        }
        
        if (!passService.validate(user.getPassword())) {
            return "The password need length 8, numbers uppercase and lowercase characters.";
        }
        
        service.save(user);
        
        return "User registered successfully.";
    }

    @PatchMapping("changepassword")
    public ResponseEntity<String> changepassword(@RequestBody PasswordUpdate data) {
        User user = service.loginByUsername(data.username());
        if (user == null) {
            return ResponseEntity.badRequest()
                .body("User do not exists.");
        }

        if (!user.getPassword().equals(data.password())) {
            return ResponseEntity.badRequest()
                .body("User current passowrd is incorrect."
            );
        }

        if (!passService.validate(data.newPassword())) {
            return ResponseEntity.badRequest()
                .body("The password need length 8, numbers uppercase and lowercase characters."
            );
        }

        if (!data.newPassword().equals(data.repeatPassword())) {
            return ResponseEntity.badRequest()
                .body("The new password need be match with repeat password field."
            );
        }

        user.setPassword(data.newPassword());
        service.save(user);

        return ResponseEntity.ok("Password has update successfully");
    }
}
