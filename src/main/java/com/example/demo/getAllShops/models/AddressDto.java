package com.example.demo.getAllShops.models;


import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class AddressDto {

    private int idAddress;
    private String addressLine;
}
