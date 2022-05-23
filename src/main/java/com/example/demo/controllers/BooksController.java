package com.example.demo.controllers;

import com.example.demo.models.BookDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class BooksController {

    @PutMapping("/bookshops/books")
    public void updateBook(@RequestBody BookDto bookDto, @RequestParam String cityOfBookshop,
                           @RequestParam Integer releaseYear, @RequestParam String typeBook) {
        if (releaseYear < 2010) {
            log.info("Book release old.");
        } else {
            log.info("Update book with type {} and year of release {} for all shops in {}. Book is - {}",
                    typeBook, releaseYear, cityOfBookshop, bookDto);
        }
    }
}
