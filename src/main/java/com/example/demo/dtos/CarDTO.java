package com.example.demo.dtos;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors
public class CarDTO {

    private int id;
    private String model;
    private int yearCreate;
}
