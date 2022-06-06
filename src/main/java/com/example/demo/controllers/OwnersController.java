package com.example.demo.controllers;

import com.example.demo.dtos.OwnerDTO;
import com.example.demo.services_Impl.OwnersServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class OwnersController {

    private final OwnersServiceImpl ownersService;

    public OwnersController(OwnersServiceImpl ownersService) {
        this.ownersService = ownersService;
    }

    @GetMapping("/owners/{id}")
    public ResponseEntity<OwnerDTO> getOwnerById(@PathVariable Integer id) {
        OwnerDTO ownerDTO = ownersService.getOwnerById(id);
        log.info("Getting owner by id {}. Owner is {}.", id, ownerDTO.getOwnerName());
        return new ResponseEntity<>(ownerDTO, HttpStatus.OK);
    }

    @PostMapping("/owners")
    public ResponseEntity<HttpStatus> createOwner(@RequestBody OwnerDTO owner) {
        ownersService.createOwner(owner);
        log.info("Owner with name {} is created. ", owner.getOwnerName());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/owners/{id}")
    public ResponseEntity<HttpStatus> deleteOwner(@PathVariable Integer id) {
        ownersService.deleteOwnerById(id);
        log.info("Deleting owner with id {}.", id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/owners/{id}")
    public ResponseEntity<HttpStatus> updateOwnerById(@RequestBody OwnerDTO ownerDTO, @PathVariable Integer id) {
        ownersService.updateOwnerById(ownerDTO, id);
        log.info("Owner with id  {} updated. New owner is {}", id, ownerDTO.getOwnerName());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}


