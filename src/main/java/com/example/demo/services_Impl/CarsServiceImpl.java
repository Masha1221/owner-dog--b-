package com.example.demo.services_Impl;


import com.example.demo.dtos.CarDTO;
import com.example.demo.entities.CarEntity;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.repositories.CarsRepository;
import com.example.demo.services.CarsService;
import org.springframework.stereotype.Service;

@Service
public class CarsServiceImpl implements CarsService {

    private final CarsRepository carsRepository;

    public CarsServiceImpl(CarsRepository carsRepository) {
        this.carsRepository = carsRepository;
    }

    @Override
    public CarEntity createCar(CarDTO car) {
        CarEntity carEntity = new CarEntity();
        carEntity.setModel(car.getModel());
        carEntity.setYearCreate(car.getYearCreate());
        return carsRepository.save(carEntity);
    }

    @Override
    public CarEntity updateCarById(CarDTO carDTO, Integer id) {
        CarEntity carEntity = carsRepository.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("Not found car with id" + id));
        carEntity.setModel(carDTO.getModel());
        carEntity.setYearCreate(carDTO.getYearCreate());
        return carsRepository.save(carEntity);
    }

    @Override
    public void deleteCarById(Integer id) {
        carsRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Not found car with id" + id));
        carsRepository.deleteById(id);

    }

    @Override
    public CarDTO getCarById(Integer id) {
        CarEntity carEntity = carsRepository.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("Not found car with id" + id));
        CarDTO carDTO = new CarDTO();
        carDTO.setModel(carEntity.getModel());
        carDTO.setYearCreate(carEntity.getYearCreate());
        return carDTO;
    }
}
