package com.example.demo.services;

import com.example.demo.dtos.NoteDTO;
import com.example.demo.entities.NoteEntity;
import org.springframework.stereotype.Component;

@Component
public interface NotesService {

    NoteEntity createNote(NoteDTO note, Integer id);

    NoteEntity updateNoteById(NoteDTO note, Integer id);

    void deleteNote(Integer id, Integer userId);

    NoteDTO getNoteById(Integer id);
}
