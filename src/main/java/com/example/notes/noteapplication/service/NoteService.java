package com.example.notes.noteapplication.service;

import com.example.notes.noteapplication.model.Note;
import com.example.notes.noteapplication.repository.NoteRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteService {

    @Autowired
    private NoteRespository noteRespository;

   //Getting all Notes

    public List<Note> getAllNote(){
        return noteRespository.findAll();
    }

    public Note createNote(Note note){
        return noteRespository.save(note);
    }

    public Optional<Note> getNoteByID(Long id){
        return noteRespository.findById(id);
    }

    public Optional<Note> updateNote(Long id, Note noteDetails){
        return noteRespository.findById(id).map(note -> {
            note.setTitle(noteDetails.getTitle());
            note.setContent(noteDetails.getContent());
            return noteRespository.save(note);
        });
    }

    public boolean deleteNote(Long id){
        return noteRespository.findById(id).map(note -> {
            noteRespository.delete(note);
            return true;
        }).orElse(false);
    }



}
