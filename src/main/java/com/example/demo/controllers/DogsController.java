package com.example.demo.controllers;

import com.example.demo.dtos.DogDTO;
import com.example.demo.services_Impl.DogsServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@Slf4j
public class DogsController {

    private final DogsServiceImpl dogsService;

    @GetMapping("/dogs/{id}")
    public ResponseEntity<HttpStatus> getDogById(@PathVariable Integer id) {
        DogDTO dogDTO = dogsService.getDogById(id);
        log.info("Get dog by id - {}. Dog is - {}. ", id, dogDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/owners/{ownerId}/dogs")
    public ResponseEntity<HttpStatus> createDog(@PathVariable(value = "ownerId") Integer id,
                                                @RequestBody DogDTO dogDTO) {
        dogsService.createDog(dogDTO, id);
        log.info("Dog for owner with id - {} is created. Dog name - {}.", id, dogDTO.getName());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("dogs/{dogId}")
    public ResponseEntity<DogDTO> updateDog(@PathVariable Integer dogId, @RequestBody DogDTO dog) {
        dogsService.updateDogById(dogId, dog);
        log.info("Dog with id  {} updated. New dog name is - {}.", dogId, dog.getName());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/owners/{ownerId}/dogs/{dogId}")
    public ResponseEntity<HttpStatus> deleteDogById(@PathVariable Integer ownerId, @PathVariable Integer dogId) {
        dogsService.deleteDog(dogId, ownerId);
        log.info("Deleting dog with id - {} for owner with id - {}.", dogId, ownerId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/dogs")
    public ResponseEntity<HttpStatus> getSumOfDogNames() {
        List<DogDTO> dogs = dogsService.getAllDogs();
        log.info("The sum of the length of dog names - {}.", dogsService.getSumOfLettersInAllDogNames(dogs));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}