package com.manpower.platform.dto;

public class LoginResponse {

    private Long userId;
    private String firstName;
    private String email;
    private String role;
    private String message;

    private String accessToken;
    private String tokenType;
    private long expiresIn;

    public LoginResponse(
            Long userId,
            String firstName,
            String email,
            String role,
            String message,
            String accessToken,
            String tokenType,
            long expiresIn) {

        this.userId = userId;
        this.firstName = firstName;
        this.email = email;
        this.role = role;
        this.message = message;
        this.accessToken = accessToken;
        this.tokenType = tokenType;
        this.expiresIn = expiresIn;
    }

    public Long getUserId() {
        return userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    public String getMessage() {
        return message;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public long getExpiresIn() {
        return expiresIn;
    }
}