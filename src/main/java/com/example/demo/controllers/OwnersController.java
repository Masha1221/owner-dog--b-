package com.example.demo.controllers;

import com.example.demo.dtos.OwnerDTO;
import com.example.demo.services_Impl.OwnersServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
@Slf4j
public class OwnersController {

    private final OwnersServiceImpl ownersService;

    @GetMapping("/owners/{id}")
    public ResponseEntity<HttpStatus> getOwnerById(@PathVariable Integer id) {
        OwnerDTO ownerDTO = ownersService.getOwnerById(id);
        log.info("Getting owner by id {}. Owner - {}.", id, ownerDTO.getName());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/owners")
    public ResponseEntity<HttpStatus> createOwner(@RequestBody OwnerDTO owner) {
        ownersService.createOwner(owner);
        log.info("Owner with name {} - created. ", owner.getName());
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
        log.info("Owner with id {} updated. New owner is {}", id, ownerDTO.getName());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/owners")
    public ResponseEntity<HttpStatus> getLongestNameOfOwner() {
        List<OwnerDTO> owners = new ArrayList<>();
        log.info("The longest name of owner - {}.", ownersService.getLongestNameOfOwner(owners));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}