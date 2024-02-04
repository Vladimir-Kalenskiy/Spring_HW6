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

/**
 * Класс контроллер
 */
@RestController
@RequestMapping("/notes")
@AllArgsConstructor
public class NoteController {
    /**
     * Объект класса репозиторий
     */
    private final NoteRepository noteRepository;

    /**
     * Метод добавления заметки
     * @param note Тело заметки
     * @return Класс оболочка для заметки
     */
    @PostMapping("/")
    public ResponseEntity<Note> addNote(@RequestBody Note note){
        note.setDateTimeOfCreated(LocalDateTime.now());
        return new ResponseEntity<>(noteRepository.save(note), HttpStatus.CREATED);
    }

    /**
     * Метод получения списка всех заметок
     * @return Класс оболочку для списка заметок
     */
    @GetMapping
    public ResponseEntity<List<Note>> getAll(){
        return new ResponseEntity<>(noteRepository.findAll(), HttpStatus.OK);
    }

    /**
     * Метод получения заметки по id
     * @param id идентификатор заметки
     * @return Класс оболочка для заметки
     */
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Note>> findById(@PathVariable("id") Long id){
        return new ResponseEntity<>(noteRepository.findById(id), HttpStatus.OK);
    }

    /**
     * Метод обновления заметки
     * @param id идентификатор заметки
     * @param note тело заметки
     * @return класс оболочка для заметки
     */
    @PutMapping("/{id}")
    public ResponseEntity<Note> updateNote(@PathVariable("id") Long id,
                                           @RequestBody Note note){
        note.setId(note.getId());
        note.setTitle(note.getTitle());
        note.setContent(note.getContent());
        note.setDateTimeOfCreated(LocalDateTime.now());
        return new ResponseEntity<>(note, HttpStatus.OK);
    }

    /**
     * Метод удаления заметки по id
     * @param id идентификатор заметки
     * @return пустой класс-оболочка
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id){
        noteRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
