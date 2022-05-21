package com.example.demo.getAllShops.controllers;

import com.example.demo.getAllShops.models.ShopDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class ShopController {

    @PostMapping("/shops")
    public ResponseEntity createStore(@RequestBody ShopDto shopDto) {
        log.info("Shop is created. Shop is {}", shopDto);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/addresses/{idAddress}/shops")
    public List<ShopDto> getAllShops(@PathVariable Integer idAddress, @RequestBody ShopDto shopDto) {
        log.info("All shops {}  by address: {}", shopDto, idAddress);
        return new ArrayList<>();
    }
}
