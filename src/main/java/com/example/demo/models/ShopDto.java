package com.example.demo.models;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ShopDto {

    private String nameShop;
}
