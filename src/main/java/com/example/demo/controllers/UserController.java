package com.example.demo.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import src.main.java.com.example.demo.Exeptions.ResourceNotFoundException;
import com.example.demo.models.User;
import com.example.demo.services.UserDAO;
import java.util.List;

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
    public ResponseEntity<User> getUserById(@PathVariable Integer id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found User with id = " + id));
        log.info("Getting user by {}", id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User user1 = userRepository.save(new User(user.getName(),user.getAge()));
        log.info("{} is created.", user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
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
