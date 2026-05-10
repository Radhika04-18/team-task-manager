package com.example.taskmanager;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import com.example.taskmanager.model.User;
import com.example.taskmanager.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class TaskmanagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaskmanagerApplication.class, args);
    }
    @Bean
    CommandLineRunner init(UserRepository userRepository) {
        return args -> {
            if (userRepository.count() == 0) {
                User admin = new User();
                admin.setUsername("admin");
                admin.setPassword("admin123");
                admin.setRole("ROLE_ADMIN");
                userRepository.save(admin);
                System.out.println("Bhai, Admin user ban gaya hai!");

                User member = new User();
                member.setUsername("shubham");
                member.setPassword("shubham123");
                member.setRole("ROLE_MEMBER"); // Iska role alag hai
                userRepository.save(member);
                System.out.println("Bhai, Member user bhi ban gaya!"); 
            }
        };  
    }
}