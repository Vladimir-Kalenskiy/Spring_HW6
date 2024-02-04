package ru.kalenskiy.homework6.service;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import ru.kalenskiy.homework6.model.Note;
import ru.kalenskiy.homework6.repository.NoteRepository;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class NoteService {
    private NoteRepository repository;

    public ResponseEntity<Note> addNote(@RequestBody Note note){
        note.setDateTimeOfCreated(LocalDateTime.now());
        return new ResponseEntity<>(repository.save(note), HttpStatus.CREATED);
    }
}
