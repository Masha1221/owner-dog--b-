package com.example.demo.controllers;


import com.example.demo.models.BookDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class BooksController {

    @PutMapping(value = "/bookshops/books")
    public void updateBook(@RequestBody BookDto book, @RequestParam String cityOfBookshop, @RequestParam Integer releaseYear,
                           @RequestParam String typeBook) {
        if (releaseYear < 2010) {
            log.info("Book release old.");
        } else {
            log.info("Update book with type by {} and year of release {} for all shops in {}. Book is - {}",
                    typeBook, releaseYear, cityOfBookshop, book);
        }
    }
}
