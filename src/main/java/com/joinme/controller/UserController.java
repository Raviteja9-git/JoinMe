package com.joinme.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joinme.pojo.UserData;
import com.joinme.service.UserService;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:8080")
public class UserController {

    @Autowired
    private UserService userService;
    
    
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserData userData) {
        userService.registerUser(userData);
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody UserData userData) {
        Map<String, Object> response = new HashMap<>();
        
        boolean userExists = userService.checkUserCredentials(userData.getUsername(), userData.getPassword());
        
        if (userExists) {
            response.put("success", true);
            response.put("message", "Login successful!");
            return ResponseEntity.ok(response); // HTTP 200
        } else {
            response.put("success", false);
            response.put("message", "Invalid username or password");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response); // HTTP 401
        }
    }
}
