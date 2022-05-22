package com.example.demo.getAllShops.models;


import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ShopDto {

    private int idShop;
    private String nameShop;
    private AddressDto addressDto;
}
