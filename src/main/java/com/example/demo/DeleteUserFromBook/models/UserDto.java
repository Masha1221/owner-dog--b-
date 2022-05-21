package com.example.demo.DeleteUserFromBook.models;


import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class UserDto {


    private int idUser;
    private String nameUser;
}
