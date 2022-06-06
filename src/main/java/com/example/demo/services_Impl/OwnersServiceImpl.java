package com.example.demo.services_Impl;

import com.example.demo.dtos.OwnerDTO;
import com.example.demo.entities.OwnerEntity;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.repositories.OwnersRepository;
import com.example.demo.services.OwnersService;
import org.springframework.stereotype.Service;

@Service
public class OwnersServiceImpl implements OwnersService {

    private final OwnersRepository ownersRepository;

    public OwnersServiceImpl(OwnersRepository ownersRepository) {
        this.ownersRepository = ownersRepository;
    }

    @Override
    public OwnerEntity createOwner(OwnerDTO ownerDTO) {
        OwnerEntity ownerEntity = new OwnerEntity();
        ownerEntity.setOwnerName(ownerDTO.getOwnerName());
        return ownersRepository.save(ownerEntity);
    }

    @Override
    public void deleteOwnerById(Integer id) {
        ownersRepository.deleteById(id);
    }

    @Override
    public OwnerEntity updateOwnerById(OwnerDTO ownerDTO, Integer id) {
        OwnerEntity owner = ownersRepository.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("Not found owner with id" + id));
        owner.setOwnerName(ownerDTO.getOwnerName());
        return ownersRepository.save(owner);
    }

    @Override
    public OwnerDTO getOwnerById(Integer id) {
        OwnerEntity owner = ownersRepository.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("Not found owner with id" + id));
        OwnerDTO ownerDTO = new OwnerDTO();
        ownerDTO.setOwnerName((owner.getOwnerName()));
        return ownerDTO;
    }
}
