package com.bosch.example.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.bosch.example.model.User;
import com.bosch.example.repositories.UserJPARepository;
import com.bosch.example.services.UserService;

public class DatabaseUser implements UserService {

    @Autowired
    UserJPARepository repo;

    public void save(User user) {
        repo.save(user);
    }

    @Override
    public User loginByUsername(String username) {
        var users = repo.findByUsername(username);
        if (users.size() == 0)
            return null;
        
        return users.get(0);
    }

    @Override
    public User loginByEmail(String email) {
        var users = repo.findByEmail(email);
        if (users.size() == 0)
            return null;
        
        return users.get(0);
    }
}
