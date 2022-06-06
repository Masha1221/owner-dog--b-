package com.example.demo.dtos;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors
public class OwnerDTO {
    private int ownerId;
    private String ownerName;
}
