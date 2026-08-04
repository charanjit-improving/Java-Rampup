package com.example.practice.dto;

public class SignupResponse {
    private String token;
        public SignupResponse() {
    }

    public SignupResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
