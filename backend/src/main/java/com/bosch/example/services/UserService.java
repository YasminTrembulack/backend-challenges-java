package com.bosch.example.services;

import com.bosch.example.model.User;

public interface UserService {
    void save(User user);
    User loginByUsername(String username);
    User loginByEmail(String email);
    User getOne(Long id);
}
