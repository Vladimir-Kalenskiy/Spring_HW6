package ru.kalenskiy.homework6.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kalenskiy.homework6.model.Note;
import ru.kalenskiy.homework6.repository.NoteRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/notes")
@AllArgsConstructor
public class NoteController {
    private final NoteRepository noteRepository;

    @PostMapping("/")
    public ResponseEntity<Note> addNote(@RequestBody Note note){
        note.setDateTimeOfCreated(LocalDateTime.now());
        return new ResponseEntity<>(noteRepository.save(note), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Note>> getAll(){
        return new ResponseEntity<>(noteRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Note>> findById(@PathVariable("id") Long id){
        return new ResponseEntity<>(noteRepository.findById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Note> updateNote(@PathVariable("id") Long id,
                                           @RequestBody Note note){
        note.setId(note.getId());
        note.setTitle(note.getTitle());
        note.setContent(note.getContent());
        note.setDateTimeOfCreated(LocalDateTime.now());
        return new ResponseEntity<>(note, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id){
        noteRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
