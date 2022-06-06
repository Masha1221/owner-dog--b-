package com.example.demo.services;

import com.example.demo.dtos.DogDTO;
import com.example.demo.entities.DogEntity;
import org.springframework.stereotype.Component;

@Component
public interface DogsService {
    DogEntity createDog(DogDTO dogDTO, Integer id);

    void deleteDog(Integer id, Integer ownerId);

    DogEntity updateDogById(Integer id, DogDTO dogDTO);

    DogDTO getDogById(Integer id);
}
