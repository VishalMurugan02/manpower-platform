package com.manpower.platform.controller;

import com.manpower.platform.entity.User;
import com.manpower.platform.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/test")
    public String test() {
        return "User API is working!";
    }
}