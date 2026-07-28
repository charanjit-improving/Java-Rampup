package com.example.practice.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.practice.dto.SignupRequest;

import jakarta.validation.Valid;

@RestController
public class UserController {
        @PostMapping("/signup")
    public String signup(
            @Valid
            @RequestBody SignupRequest request) {

        return "User Created";
    }

}
