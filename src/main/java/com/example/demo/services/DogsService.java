package com.example.demo.services;

import com.example.demo.dtos.DogDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface DogsService {

    DogDTO createDog(DogDTO dogDTO, Integer id);

    void deleteDog(Integer id, Integer ownerId);

    DogDTO updateDogById(Integer id, DogDTO dogDTO);

    DogDTO getDogById(Integer id);

    List<DogDTO> getAllDogs();

    int getSumOfLettersInAllDogNames(List<DogDTO> dogs);
}
