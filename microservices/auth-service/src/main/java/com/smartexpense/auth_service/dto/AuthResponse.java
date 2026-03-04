package com.smartexpense.auth_service.dto;

public class AuthResponse {
    private String token;

    public AuthResponse(String message) {
        this.token = message;
    }

    public String getMessage() {
        return token;
    }
}