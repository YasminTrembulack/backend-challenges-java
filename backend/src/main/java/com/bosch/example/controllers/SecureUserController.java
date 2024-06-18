package com.bosch.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RestController;

import com.bosch.example.JWTService;
import com.bosch.example.dto.JWTUserData;
import com.bosch.example.dto.ResponseAuth;
import com.bosch.example.dto.UserLogin;
import com.bosch.example.model.User;
import com.bosch.example.services.EmailValidatorService;
import com.bosch.example.services.PasswordValidatorService;
import com.bosch.example.services.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class SecureUserController {
    
    @Autowired
    PasswordEncoder encoder;

    @Autowired
    UserService service;

    @Autowired
    EmailValidatorService emailService;

    @Autowired
    PasswordValidatorService passService;

    @Autowired
    JWTService<JWTUserData> jwt;

    @PostMapping("login")
    public ResponseEntity<ResponseAuth> loginUser(@RequestBody UserLogin entity) {
        var user = service.loginByEmail(entity.login());
        user = user != null ? user : service.loginByUsername(entity.login());

        if(user == null)
            return ResponseEntity.status(401)
                .body(new ResponseAuth("Unknow user.", null));

        if(!encoder.matches(entity.password(), user.getPassword()))
            return ResponseEntity.status(401)
                .body(new ResponseAuth("Wrong password.", null));
        
        var token = jwt.get(new JWTUserData(user.getId()));
        return ResponseEntity.ok(new ResponseAuth("successfull login", token));
    }
    


    @PostMapping("user")
    public String saveUser(@RequestBody User user) {
        
        if (user.getUsername() == null || user.getUsername().length() < 4) 
            return "Username is too short.";

        if(!emailService.validate(user.getEmail()))
            return"Email is too short or invalid.";

        if (service.loginByUsername(user.getUsername()) != null) 
            return "The username already exists.";

        if (service.loginByEmail(user.getEmail()) != null) 
            return "The email already exists.";

        if (!passService.validate(user.getPassword())) 
            return "The password need length 8, numbers uppercase and lowercase characters.";
        
        var password = user.getPassword();
        password = encoder.encode(password);
        user.setPassword(password);
        System.out.println(password);

        service.save(user);
        
        return "User registered successfully.";
    }
    

}
