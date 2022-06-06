package com.example.demo.repositories;

import com.example.demo.entities.OwnerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnersRepository extends JpaRepository<OwnerEntity, Integer> {

}
