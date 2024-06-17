package com.bosch.example.dto;

public record PasswordUpdate (
    String username,
    String password,
    String newPassword,
    String repeatPassword
){}
