package com.example.demo.services;

import com.example.demo.dtos.OwnerDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface OwnersService {

    OwnerDTO createOwner(OwnerDTO ownerDTO);

    void deleteOwnerById(Integer id);

    OwnerDTO updateOwnerById(OwnerDTO ownerDTO, Integer id);

    OwnerDTO getOwnerById(Integer id);

    List<OwnerDTO> getAllOwners();

    String getLongestNameOfOwner(List<OwnerDTO> owners);
}
