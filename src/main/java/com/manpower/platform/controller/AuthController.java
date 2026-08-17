package com.manpower.platform.controller;

import com.manpower.platform.dto.RegisterRequest;
import com.manpower.platform.entity.User;
import com.manpower.platform.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import com.manpower.platform.dto.LoginRequest;
import com.manpower.platform.dto.LoginResponse;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public User register(@Valid @RequestBody RegisterRequest request) {

        return userService.registerUser(request);
    }

    // Login
    
    @PostMapping("/login")
    public LoginResponse login(@Valid @RequestBody LoginRequest request) {
        return userService.loginUser(request);
    }
}