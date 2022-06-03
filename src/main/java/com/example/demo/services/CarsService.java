package com.example.demo.services;

import com.example.demo.dtos.CarDTO;
import com.example.demo.entities.CarEntity;
import org.springframework.stereotype.Component;

@Component
public interface CarsService {

    CarEntity createCar(CarDTO  car);

    CarEntity updateCarById(CarDTO car, Integer id);

    void deleteCarById(Integer id);

    CarDTO getCarById(Integer id);
}
