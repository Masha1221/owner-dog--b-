package com.example.demo.services_Impl;

import com.example.demo.dtos.DogDTO;
import com.example.demo.entities.DogEntity;
import com.example.demo.entities.OwnerEntity;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.repositories.DogsRepository;
import com.example.demo.repositories.OwnersRepository;
import com.example.demo.services.DogsService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DogsServiceImpl implements DogsService {

    private final ModelMapper modelMapper;
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

    @Override
    public List<DogDTO> getAllDogs() {
        return dogsRepository.findAll().stream().map(entity -> modelMapper.map(entity, DogDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public int getSumOfLettersInAllDogNames(List<DogDTO> dogs) {
        int sumOfLetters = 0;
        for (DogDTO dogDTO : dogs) {
            if (dogDTO.getName().length() > 0) {
                sumOfLetters += dogDTO.getName().length();
            }
        }
        return sumOfLetters;
    }
}
