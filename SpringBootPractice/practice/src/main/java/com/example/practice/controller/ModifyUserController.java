package com.example.practice.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.practice.dto.UserRequest;
import com.example.practice.validation.OnCreate;
import com.example.practice.validation.OnUpdate;

@RestController
@RequestMapping("/users")
public class ModifyUserController {
    @PostMapping
    public String createUser(
            @Validated(OnCreate.class)
            @RequestBody UserRequest request) {

        return "User Created";
    }

    @PutMapping
    public String updateUser(
            @Validated(OnUpdate.class)
            @RequestBody UserRequest request) {

        return "User Updated";
    }
}
