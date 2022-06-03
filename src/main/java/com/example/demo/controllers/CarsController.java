package com.example.demo.controllers;


import com.example.demo.dtos.CarDTO;
import com.example.demo.entities.CarEntity;
import com.example.demo.services_Impl.CarsServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class CarsController {

    private final CarsServiceImpl carsService;

    public CarsController(CarsServiceImpl carsService) {
        this.carsService = carsService;
    }

    @GetMapping("/cars/{id}")
    public ResponseEntity<CarDTO> getCarById(@PathVariable Integer id) {
        CarDTO car = carsService.getCarById(id);
        log.info("Getting car by id - {}. Car - {}, year of created - {}", id, car.getModel(), car.getYearCreate());
        return new ResponseEntity<>(car, HttpStatus.OK);
    }

    @PostMapping("/cars")
    public ResponseEntity<HttpStatus> createCar(@RequestBody CarDTO carDTO) {
        CarEntity carEntity = carsService.createCar(carDTO);
        log.info(" Car is created. The model of car - {}, year of created - {}, id of car - {}. ",
                carEntity.getModel(), carEntity.getYearCreate(), carEntity.getId());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/cars/{id}")
    public ResponseEntity<HttpStatus> deleteCar(@PathVariable Integer id) {
        carsService.deleteCarById(id);
        log.info("Car with id {} deleted.", id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/cars/{id}")
    public ResponseEntity<HttpStatus> updateUserById(@RequestBody CarDTO carDTO, @PathVariable Integer id) {
        CarEntity carEntity = carsService.updateCarById(carDTO, id);
        log.info("Car with id {} updated. New car - {} , year of created {}. ",
                id, carEntity.getModel(), carEntity.getYearCreate());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
