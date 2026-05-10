package com.example.taskmanager.controller;

import com.example.taskmanager.model.User;
import com.example.taskmanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*") // Sab origins allow karne ke liye
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        // Simple Logic for Presentation
        List<User> users = userRepository.findAll();
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return "Login Successful! Welcome " + username;
            }
        }
        return "Invalid Username or Password";
    }

    @GetMapping("") // Isse http://localhost:8080/api/users chalne lagega
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}