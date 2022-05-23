package com.example.demo.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class PackagesController {

    @DeleteMapping("/post_offices/packages/{idPackage}")
    public void deletePackageByNumber(@PathVariable Integer idPackage) {
        log.info("Delete package bu number {} in all post offices.", idPackage);
    }
}
