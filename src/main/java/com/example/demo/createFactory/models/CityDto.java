package com.example.demo.createFactory.models;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class CityDto {

    private int idCity;
    private String nameCity;
}
