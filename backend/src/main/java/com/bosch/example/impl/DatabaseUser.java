package com.bosch.example.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.bosch.example.model.User;
import com.bosch.example.repositories.UserJPARepository;
import com.bosch.example.services.UserService;

public class DatabaseUser implements UserService {

    @Autowired
    UserJPARepository repo;

    @Override
    public String save(User user) {
        if (user.getUsername() == null) {
            return "Username NULL";
        } else if (user.getEmail() == null) {
            return "Email NULL";
        } else if (user.getPassword() == null) {
            return "Password NULL";
        }
        

        repo.save(user);

        return "Usuário criado com sucesso!";
    }
}
