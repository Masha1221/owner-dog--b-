package com.example.demo.controllers;

import com.example.demo.models.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class UsersController {

    @GetMapping("/warehouses/{idWarehouse}/users")
    public UserDto getUserByName(@PathVariable Integer idWarehouse, @RequestParam String nameUser) {
        log.info("Get a user by name {} in a warehouse with number {}", nameUser, idWarehouse);
        return new UserDto();
    }
}
