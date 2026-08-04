package com.example.practice.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/api/whoami")
    public Map<String, Object> whoAmI(Authentication authentication) {

        Map<String, Object> response = new HashMap<>();

        response.put("username", authentication.getName());

        response.put(
                "roles",
                authentication.getAuthorities()
                        .stream()
                        .map(GrantedAuthority::getAuthority)
                        .collect(Collectors.toList())
        );

        return response;
    }
    @GetMapping("/test-user")
    public Map<String, Object> testUser(Authentication authentication) {

        Map<String, Object> response = new HashMap<>();
        response.put("username", authentication.getName());
        response.put(
                "roles",
                authentication.getAuthorities()
                        .stream()
                        .map(GrantedAuthority::getAuthority)
                        .collect(Collectors.toList())
        );

        return response;
    }
}
