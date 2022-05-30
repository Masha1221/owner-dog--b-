package com.example.demo.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import src.main.java.com.example.demo.Exeptions.ResourceNotFoundException;
import com.example.demo.models.Note;
import com.example.demo.services.NoteDAO;
import com.example.demo.services.UserDAO;
import java.util.List;

@RestController
@Slf4j
public class NoteController {

    final NoteDAO noteRepository;
    final UserDAO userRepository;

    public NoteController(NoteDAO noteRepository, UserDAO userRepository) {
        this.noteRepository = noteRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/users/{user_id}/notes")
    public ResponseEntity<List<Note>> getAllNotesByUserId(@PathVariable Integer user_id) {
        if (!noteRepository.existsById(user_id)) {
            throw new ResourceNotFoundException("Not found User with id = " + user_id);
        }
        List<Note> notes = noteRepository.findUserById(user_id);
        log.info("Get all notes of user by id - {}.", user_id);
        return new ResponseEntity<>(notes, HttpStatus.OK);
    }

    @GetMapping("/notes/{id}")
    public ResponseEntity<Note> getNoteById(@PathVariable(value = "id") Integer id) {
        Note note = noteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found Note with id = " + id));
        log.info("Get note by id - {}", id);
        return new ResponseEntity<>(note, HttpStatus.OK);
    }

    @PostMapping("/users/{user_id}/notes")
    public ResponseEntity<Note> createNoteForUser(@PathVariable(value = "user_id") Integer id,
                                                  @RequestBody Note note) {
        Note note1 = userRepository.findById(id).map(user -> {
            note.setUser(user);
            return noteRepository.save(note);
        }).orElseThrow(() -> new ResourceNotFoundException("Not found User with id = " + id));
        log.info("Note for user with id - {} is created. Note - {}", id, note);
        return new ResponseEntity<>(note, HttpStatus.CREATED);
    }

    @PutMapping("notes/{note_id}")
    public ResponseEntity<Note> updateNote(@PathVariable Integer note_id, @RequestBody Note note) {
        Note note1 = noteRepository.findById(note_id)
                .orElseThrow(() -> new ResourceNotFoundException("NoteId " + note_id + "not found"));
        log.info("Note with id - {} is updated. New note - {} ", note_id, note);
        return new ResponseEntity<>(noteRepository.save(note), HttpStatus.OK);
    }

    @DeleteMapping("/users/{user_id}/notes")
    public ResponseEntity<List<Note>> deleteAllNotesOfUser(@PathVariable(value = "user_id") Integer id) {
        if (!userRepository.existsById(id)) {
            throw new ResourceNotFoundException("Not found User with id = " + id);
        }
        noteRepository.deleteByUserId(id);
        log.info("Delete all notes for user by id - {}.", id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
