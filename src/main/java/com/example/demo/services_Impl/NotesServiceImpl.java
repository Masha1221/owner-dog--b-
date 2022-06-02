package com.example.demo.services_Impl;

import com.example.demo.dtos.NoteDTO;
import com.example.demo.entities.NoteEntity;
import com.example.demo.entities.UserEntity;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.repositories.NotesRepository;
import com.example.demo.repositories.UsersRepository;
import com.example.demo.services.NotesService;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class NotesServiceImpl implements NotesService {

    private final NotesRepository notesRepository;
    private final UsersRepository usersRepository;

    public NotesServiceImpl(NotesRepository notesRepository, UsersRepository usersRepository) {
        this.notesRepository = notesRepository;
        this.usersRepository = usersRepository;
    }

    @Override
    public NoteEntity createNote(NoteDTO note, Integer userId) {
        NoteEntity noteEntity = new NoteEntity();
        noteEntity.setNote(note.getNote());
        Optional<UserEntity> user = usersRepository.findById(userId);
        UserEntity userEntity = user.orElseThrow();
        noteEntity.setUser(userEntity);
        return notesRepository.save(noteEntity);
    }

    @Override
    public NoteEntity updateNoteById(NoteDTO note, Integer id) {
        NoteEntity noteEntity = notesRepository.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("Not found note with id" + id));
        noteEntity.setNote(note.getNote());
        return notesRepository.save(noteEntity);
    }

    @Override
    public void deleteNote(Integer noteId, Integer userId) {
        NoteEntity noteEntity = notesRepository.findByIdAndUserId(noteId, userId);
        if (noteEntity == null) {
            throw new ResourceNotFoundException();
        }
        notesRepository.delete(noteEntity);
    }

    @Override
    public NoteDTO getNoteById(Integer id) {
        NoteEntity note = notesRepository.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("Not found user with id" + id));
        NoteDTO noteDTO = new NoteDTO();
        noteDTO.setNote(note.getNote());
        return noteDTO;
    }
}
