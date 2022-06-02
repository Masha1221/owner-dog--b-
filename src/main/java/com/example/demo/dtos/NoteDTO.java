package com.example.demo.dtos;

import lombok.*;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class NoteDTO {

    private int id;
    private String note;
}