package com.example.demo.createFactory.models;


import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class FactoryDto {

    private int idFactory;
    private String nameFactory;
}
