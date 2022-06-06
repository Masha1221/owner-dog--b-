package com.example.demo.services;

import com.example.demo.dtos.OwnerDTO;
import com.example.demo.entities.OwnerEntity;
import org.springframework.stereotype.Component;

@Component
public interface OwnersService {
    OwnerEntity createOwner(OwnerDTO ownerDTO);

    void deleteOwnerById(Integer id);

    OwnerEntity updateOwnerById(OwnerDTO ownerDTO, Integer id);

    OwnerDTO getOwnerById(Integer id);
}
