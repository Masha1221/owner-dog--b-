package com.example.demo.repositories;

import com.example.demo.entities.NoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotesRepository extends JpaRepository<NoteEntity, Integer> {
        NoteEntity findByIdAndUserId(Integer Id, Integer userId);
}
