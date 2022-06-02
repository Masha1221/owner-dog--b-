package com.example.demo.controllers;

import com.example.demo.dtos.UserDTO;
import com.example.demo.entities.UserEntity;
import com.example.demo.services_Impl.UsersServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class UsersController {

    private final UsersServiceImpl userService;

    public UsersController(UsersServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Integer id) {
        UserDTO user = userService.getUserById(id);
        log.info("Getting user by id - {}. User is - {}", id, user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity<HttpStatus> createUser(@RequestBody UserDTO userDTO) {
        UserEntity user = userService.createUser(userDTO);
        log.info("{} is created.", user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable Integer id) {
        userService.deleteUserById(id);
        log.info("Deleting user with id - {}.", id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<HttpStatus> updateUserById(@RequestBody UserDTO userDTO, @PathVariable Integer id) {
        userService.updateUserById(id, userDTO);
        log.info("User with id  {} updated.", id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}


