package com.example.demo.services;

import com.example.demo.dtos.UserDTO;
import com.example.demo.entities.UserEntity;
import org.springframework.stereotype.Component;

@Component
public interface UsersService {
    UserEntity createUser(UserDTO userDTO);

    UserEntity updateUserById(Integer id, UserDTO userDTO);

    void deleteUserById(Integer id);

    UserDTO getUserById(Integer id);
}
