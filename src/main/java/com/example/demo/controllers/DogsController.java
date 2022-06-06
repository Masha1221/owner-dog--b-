package com.example.demo.controllers;

import com.example.demo.dtos.DogDTO;
import com.example.demo.services_Impl.DogsServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class DogsController {
    private final DogsServiceImpl dogsService;

    public DogsController(DogsServiceImpl dogsService) {
        this.dogsService = dogsService;
    }

    @GetMapping("/dogs/{id}")
    public ResponseEntity<DogDTO> getDogById(@PathVariable Integer id) {
        DogDTO dogDTO = dogsService.getDogById(id);
        log.info("Get dog by id - {}. Dog is - {}. ", id, dogDTO);
        return new ResponseEntity<>(dogDTO, HttpStatus.OK);
    }

    @PostMapping("/owners/{ownerId}/dogs")
    public ResponseEntity<HttpStatus> createDog(@PathVariable(value = "ownerId") Integer id,
                                                @RequestBody DogDTO dogDTO) {
        dogsService.createDog(dogDTO, id);
        log.info("Dog for owner with id - {} is created. Dog name - {}.", id, dogDTO.getDogName());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("dogs/{dogId}")
    public ResponseEntity<DogDTO> updateNote(@PathVariable Integer dogId, @RequestBody DogDTO dog) {
        dogsService.updateDogById(dogId, dog);
        log.info("Dog with id  {} updated. New dog name is - {}.", dogId, dog.getDogName());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/owners/{ownerId}/dogs/{dogId}")
    public ResponseEntity<HttpStatus> deleteNoteById(@PathVariable(value = "ownerId") Integer id,
                                                     @PathVariable(value = "dogId") Integer id1) {
        dogsService.deleteDog(id1, id);
        log.info("Deleting dog with id - {} for owner with id - {}.", id1, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}