package com.example.demo.createFactory.controllers;


import com.example.demo.createFactory.models.FactoryDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class FactoryController {

    @PostMapping("/cities/{idCity}/factory")
    public ResponseEntity createFactory(@RequestBody FactoryDto factoryDto, @PathVariable Integer idCity) {
        log.info("Factory for city by id {} is created. Factory - {}", idCity, factoryDto);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
