package com.example.demo.models;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class PackageDto {

    private int idPackage;
}
