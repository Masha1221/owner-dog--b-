package com.example.demo.DeleteUserFromBook.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class UserController {

    @DeleteMapping("/books/{idBook}/users/{nameUser}")
    public void deleteUser(@PathVariable Integer idBook, @PathVariable String nameUser) {
        log.info("User {} was removed from PhoneBook number {} ", nameUser, idBook);
    }
}
