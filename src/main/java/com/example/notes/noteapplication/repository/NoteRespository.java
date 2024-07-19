package com.example.notes.noteapplication.repository;

import com.example.notes.noteapplication.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRespository extends JpaRepository<Note, Long> {
}
