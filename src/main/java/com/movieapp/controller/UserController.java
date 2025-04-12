package com.movieapp.controller;

import com.movieapp.model.User;
import com.movieapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/users")

@CrossOrigin(
    origins = {
        "http://localhost:3001",
        "https://video-store-murex.vercel.app"
    },
    allowCredentials = "true"
)
public class UserController {

    @Autowired
    private UserService userService;

    // Register a new user
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestParam String email, @RequestParam String password) {
        try {
            User user = userService.registerUser(email, password);
            Map<String, Object> response = new HashMap<>();
            response.put("success", true);
            response.put("email", user.getEmail());
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            Map<String, Object> error = new HashMap<>();
            error.put("success", false);
            error.put("message", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(
            @RequestParam String email, 
            @RequestParam String password,
            HttpSession session) {
        
        boolean authenticated = userService.authenticateUser(email, password);
        
        if (authenticated) {
            session.setAttribute("userEmail", email);
            session.setAttribute("isAuthenticated", true);
            
            Map<String, Object> response = new HashMap<>();
            response.put("success", true);
            response.put("email", email);
            
            return ResponseEntity.ok(response);
        } else {
            Map<String, Object> error = new HashMap<>();
            error.put("success", false);
            error.put("message", "Invalid email or password");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(error);
        }
    }
    
    @GetMapping("/profile")
public ResponseEntity<?> getUserProfile(HttpSession session) {
    Boolean isAuthenticated = (Boolean) session.getAttribute("isAuthenticated");
    String sessionEmail = (String) session.getAttribute("userEmail");

    if (isAuthenticated == null || !isAuthenticated) {
        Map<String, Object> error = new HashMap<>();
        error.put("success", false);
        error.put("message", "Not authenticated");
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(error);
    }

    User user = userService.findUserByEmail(sessionEmail);
    if (user == null) {
        return ResponseEntity.notFound().build();
    }

    Map<String, Object> response = new HashMap<>();
    response.put("success", true);
    response.put("email", user.getEmail());
    return ResponseEntity.ok(response);
}

    
    @PostMapping("/logout")
    public ResponseEntity<?> logout(HttpSession session) {
        session.invalidate();
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        return ResponseEntity.ok(response);
    }
}