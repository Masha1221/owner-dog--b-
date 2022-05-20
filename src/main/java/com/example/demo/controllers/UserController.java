package com.example.demo.controllers;


import com.example.demo.model.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class UserController {
    
    @PostMapping("/users")
    public ResponseEntity createUser(@RequestBody UserDto user) {
        log.info("User is created. User is {}", user);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/users/{id}")
    public UserDto getUser(@PathVariable Integer id) {
        String name = "Masha";
        log.info("Get user by id: {}", id);
        return new UserDto().setId(1).setName("Mariya");
    }

    @GetMapping("/users")
    public List<UserDto> getUsers() {
        String name = "Masha";
        log.info("Get user by id: {}", id);
        return new ArrayList<>();
    }

    @PutMapping("/users/{id}")
    public void updateUser(@PathVariable Integer id, @RequestBody UserDto user) {
        log.info("User with id {} updated. User info {}", id, user);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Integer id) {
        log.info("User is deleted with id {}", id);
    }
}