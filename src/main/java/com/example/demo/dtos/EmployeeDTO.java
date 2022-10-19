package com.example.demo.dtos;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors
public class EmployeeDTO {

    private int id;
    private String name;
    private boolean active;
}
