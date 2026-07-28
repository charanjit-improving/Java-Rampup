package com.example.practice.dto;

import com.example.practice.validation.OnCreate;
import com.example.practice.validation.OnUpdate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class UserRequest {

    @NotNull(
            groups = OnUpdate.class,
            message = "Id is required while updating")
    private Long id;

    @NotBlank(
            groups = {OnCreate.class, OnUpdate.class},
            message = "Email is required")
    @Email(
            groups = {OnCreate.class, OnUpdate.class},
            message = "Invalid Email")
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
}
