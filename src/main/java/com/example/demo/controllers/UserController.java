package com.example.demo.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.models.User;
import com.example.demo.services.UserDAO;

import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
public class UserController {

    final
    UserDAO userRepository;

    public UserController(UserDAO userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        log.info("Getting all users.");
        return userRepository.findAll();
    }

    @GetMapping("/users/{id}")
    public Optional<User> getUserById(@PathVariable Integer id) {
        Optional<User> user = userRepository.findById(id);
        log.info("Getting user by id - {}", id);
        return user;
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User user1 = userRepository.save(user);
        log.info("{} is created.", user1);
        return new ResponseEntity<>(user1, HttpStatus.CREATED);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") Integer id) {
        userRepository.deleteById(id);
        log.info("Deleting user with id - {}.", id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/users")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        userRepository.save(user);
        log.info("{} is updated.", user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}


