package com.example.practice.dto;

import com.example.practice.validation.ValidUsername;

import jakarta.validation.constraints.NotBlank;

public class SignupRequest {

    //@ValidUsername
    @NotBlank(message = "Username is required")
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
}
