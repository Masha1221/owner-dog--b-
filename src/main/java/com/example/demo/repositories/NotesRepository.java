package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entities.NoteEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface NotesRepository extends JpaRepository<NoteEntity, Integer> {
    NoteEntity findByIdAndUserId(Integer Id, Integer userId);
}
