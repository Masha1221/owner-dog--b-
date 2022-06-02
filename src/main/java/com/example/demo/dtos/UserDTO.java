package com.example.demo.dtos;

import lombok.*;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class UserDTO {

    private Integer id;
    private String name;
    private Integer age;
}