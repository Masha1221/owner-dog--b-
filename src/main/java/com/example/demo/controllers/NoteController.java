package com.example.demo.controllers;


import com.example.demo.model.NoteDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class NoteController {

    @PostMapping("users/{id}/notes")
    public ResponseEntity createNote(@RequestBody NoteDto noteDto, @PathVariable Integer id) {
        log.info("Note is created: {}", noteDto);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("users/{id}/notes")
    public NoteDto getNote(@PathVariable Integer id, @RequestBody NoteDto note) {
        log.info("Getting note of an user by id: {}. Note - {}", id, note);
        return new NoteDto().setId(2).setName("It`s really good idea ");
    }

    @PutMapping("users/{id}/notes/{id1}")
    public void updateNote(@PathVariable Integer id, @RequestBody NoteDto noteDto, @PathVariable Integer id1) {
        log.info("{} for user with id {} - updated", noteDto, id);
    }

    @DeleteMapping("users/{id}/notes/{id1}")
    public void deleteNote(@PathVariable Integer id, @PathVariable Integer id1) {
        log.info("User is deleted with id {}. Also has been delete note with id - {}", id, id1);
    }
}
