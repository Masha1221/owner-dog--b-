package com.example.demo.controllers;

import com.example.demo.models.CarDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@Slf4j
public class CarShowroomController {

    @PutMapping("/car_showrooms/")
    public void updateCarInCarShowroom(@RequestBody CarDto carDto, @RequestParam String locationCarShowroom,
                                       @RequestParam Integer idCar, @RequestParam String typeCar) {
        log.info("Car with id {} and type {} in car showroom with location {} is updated. Car info - {}. ",
                idCar, typeCar, locationCarShowroom, carDto);
    }
}
