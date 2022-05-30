package com.example.demo.services;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.models.Note;
import javax.transaction.Transactional;
import java.util.List;

public interface NoteDAO extends JpaRepository<Note, Integer> {

    List<Note> findUserById(Integer id);

    @Transactional
    void deleteByUserId(Integer id);
}
