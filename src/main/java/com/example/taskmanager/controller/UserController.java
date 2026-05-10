package com.example.taskmanager.controller;

import com.example.taskmanager.model.User;
import com.example.taskmanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users") // Path check karo: /api/users
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User loginUser) {
        // Saare users nikal kar check karo (Simple way for assignment)
        List<User> users = userRepository.findAll();
        for (User user : users) {
            if (user.getUsername().equals(loginUser.getUsername()) && 
                user.getPassword().equals(loginUser.getPassword())) {
                return ResponseEntity.ok(user);
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Credentials");
    }

    @GetMapping("") // Isse http://localhost:8080/api/users chalne lagega
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}