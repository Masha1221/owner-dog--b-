package com.example.demo.services;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.models.User;

public interface UserDAO extends JpaRepository<User, Integer> {

}
