package com.example.demo.getAllShops.controllers;


import com.example.demo.getAllShops.models.AddressDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class AddressController {

    @PostMapping("/address")
    public ResponseEntity createAddress(@RequestBody AddressDto addressDto){
        log.info("Address {} is created. ", addressDto);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
