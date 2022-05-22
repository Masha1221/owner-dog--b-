package com.example.demo.models;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class LaptopDto {

    private int idLaptop;
    private String nameLaptop;
}
