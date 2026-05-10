package com.example.taskmanager.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users") // "users" is better than "user" because USER is a reserved keyword in some SQL DBs
@Data // Automatically generates getters, setters, equals, and toString
@NoArgsConstructor // Generates a default constructor
@AllArgsConstructor // Generates a constructor with all fields
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    // This fulfills the "Role-based access" requirement from your image
    @Column(nullable = false)
    private String role; // Values should be "ROLE_ADMIN" or "ROLE_MEMBER"
}