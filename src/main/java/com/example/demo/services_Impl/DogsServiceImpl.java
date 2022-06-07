package com.example.demo.services_Impl;

import com.example.demo.dtos.DogDTO;
import com.example.demo.entities.DogEntity;
import com.example.demo.entities.OwnerEntity;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.repositories.DogsRepository;
import com.example.demo.repositories.OwnersRepository;
import com.example.demo.services.DogsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DogsServiceImpl implements DogsService {

    private final DogsRepository dogsRepository;
    private final OwnersRepository ownersRepository;

    @Override
    public DogDTO createDog(DogDTO dogDTO, Integer ownerId) {
        DogEntity dogEntity = new DogEntity();
        dogEntity.setName(dogDTO.getName());
        Optional<OwnerEntity> owner = ownersRepository.findById(ownerId);
        OwnerEntity ownerEntity = owner.orElseThrow();
        dogEntity.setOwnerEntity(ownerEntity);
        dogsRepository.save(dogEntity);
        return dogDTO;
    }

    @Override
    public void deleteDog(Integer dogId, Integer ownerId) {
        DogEntity dogEntity = dogsRepository.findByIdAndOwnerEntityId(dogId, ownerId);
        if (dogEntity == null) {
            throw new ResourceNotFoundException("These IDs are not exist.");
        }
        dogsRepository.delete(dogEntity);
    }

    @Override
    public DogDTO updateDogById(Integer id, DogDTO dogDTO) {
        DogEntity dogEntity = dogsRepository.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("Not found dog with id" + id));
        dogEntity.setName(dogDTO.getName());
        dogsRepository.save(dogEntity);
        return dogDTO;
    }

    @Override
    public DogDTO getDogById(Integer id) {
        DogEntity dog = dogsRepository.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("Not found dog with id" + id));
        DogDTO dogDTO = new DogDTO();
        dogDTO.setName(dog.getName());
        return dogDTO;
    }
}
