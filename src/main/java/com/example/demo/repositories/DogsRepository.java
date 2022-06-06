package com.example.demo.repositories;

import com.example.demo.entities.DogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DogsRepository extends JpaRepository<DogEntity, Integer> {

    DogEntity findByDogIdAndOwnerEntityOwnerId(Integer id, Integer ownerId);
}
