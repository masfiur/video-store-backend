package com.movieapp.controller;

import com.movieapp.model.User;
import com.movieapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Register a new user
    @PostMapping("/register")
    public User registerUser(@RequestParam String email, @RequestParam String password) {
        return userService.registerUser(email, password);
    }

    // Authenticate a user
    @PostMapping("/login")
    public boolean authenticateUser(@RequestParam String email, @RequestParam String password) {
        return userService.authenticateUser(email, password);
    }
}
