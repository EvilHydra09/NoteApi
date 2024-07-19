package com.example.notes.noteapplication.controller;

import com.example.notes.noteapplication.model.Note;
import com.example.notes.noteapplication.service.NoteService;
import org.springframework.beans.factory.annotation .Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/notes")
public class NotesController {


    @Autowired
    NoteService noteService;

    @GetMapping
    public List<Note> getAllNotes(){
        return noteService.getAllNote();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Note> getNoteById(@PathVariable Long id){
        return noteService.getNoteByID(id)
                .map(note -> ResponseEntity.ok().body(note))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public Note saveNote(@RequestBody Note note){
        return noteService.createNote(note);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Note> updateNote(@PathVariable Long id, @RequestBody Note note){
        return noteService.updateNote(id,note)
                .map(updateNote -> ResponseEntity.ok().body(updateNote))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable Long id){
        if(noteService.deleteNote(id)){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

}
