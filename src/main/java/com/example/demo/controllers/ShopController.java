package com.example.demo.controllers;

import com.example.demo.models.LaptopDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ShopController {

    @GetMapping("/shops")
    public LaptopDto findLaptopByIDAndName(@RequestParam String nameShop, @RequestParam Integer idLaptop, @RequestParam String nameLaptop){
        log.info("Get a laptop by id {} and name {} from the {} shop.", idLaptop, nameLaptop, nameShop );
        return new LaptopDto();
    }
}
