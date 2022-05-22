package com.example.demo.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class DataBaseDto {

    @DeleteMapping("/database")
    public void deleteLineByIdFromDataBase(@RequestParam Integer idLine) {
        log.info("Line with id {} is deleted from DataBase.", idLine);
    }
}
