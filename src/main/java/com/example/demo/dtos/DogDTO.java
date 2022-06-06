package com.example.demo.dtos;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors
public class DogDTO {
    private int dogId;
    private String dogName;
}
