package com.example.demo.services_Impl;

import com.example.demo.dtos.UserDTO;
import com.example.demo.entities.UserEntity;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.repositories.UsersRepository;
import com.example.demo.services.UsersService;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements UsersService {
    private final UsersRepository usersRepository;

    public UsersServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public UserEntity createUser(UserDTO user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setAge(user.getAge());
        userEntity.setName(user.getName());
        return usersRepository.save(userEntity);
    }

    @Override
    public UserEntity updateUserById(Integer id, UserDTO userDTO) {
        UserEntity user = usersRepository.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("Not found user with id" + id));
        userDTO.setAge(user.getAge());
        userDTO.setName(user.getName());
        return usersRepository.save(user);
    }

    @Override
    public void deleteUserById(Integer id) {
        usersRepository.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("Not found user with id" + id));
        usersRepository.deleteById(id);
    }

    @Override
    public UserDTO getUserById(Integer id) {
        UserEntity userEntity = usersRepository.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("Not found user with id" + id));
        UserDTO userDTO = new UserDTO();
        userDTO.setName(userEntity.getName());
        userDTO.setAge(userEntity.getAge());
        return userDTO;
    }
}
