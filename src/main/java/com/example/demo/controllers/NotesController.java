package com.example.demo.controllers;

import com.example.demo.dtos.NoteDTO;
import com.example.demo.services_Impl.NotesServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entities.NoteEntity;

@RestController
@Slf4j
public class NotesController {

    private final NotesServiceImpl notesService;

    public NotesController(NotesServiceImpl notesService) {
        this.notesService = notesService;
    }

    @GetMapping("/notes/{id}")
    public ResponseEntity<NoteDTO> getNoteById(@PathVariable(value = "id") Integer id) {
        NoteDTO noteDTO = notesService.getNoteById(id);
        log.info("Get note by id - {}.Note is - {}", id, noteDTO);
        return new ResponseEntity<>(noteDTO, HttpStatus.OK);
    }

    @PostMapping("/users/{userId}/notes")
    public ResponseEntity<HttpStatus> createNote(@PathVariable(value = "userId") Integer id,
                                                 @RequestBody NoteDTO note) {
        NoteEntity noteEn = notesService.createNote(note, id);
        log.info("Note for user with id - {} is created. Note name - {}, note id - {}", id, noteEn.getNote(), noteEn.getId());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("notes/{noteId}")
    public ResponseEntity<NoteDTO> updateNote(@PathVariable Integer noteId, @RequestBody NoteDTO note) {
        notesService.updateNoteById(note, noteId);
        log.info("Note with id  {} updated. New note name is - {}", noteId, note.setNote(note.getNote()));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/users/{userId}/notes/{noteId}")
    public ResponseEntity<HttpStatus> deleteNoteById(@PathVariable(value = "userId")
                                                     Integer id, @PathVariable(value = "noteId") Integer id1) {
        notesService.deleteNote(id1, id);
        log.info("Deleting note with id - {} for user with id - {}", id1, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

