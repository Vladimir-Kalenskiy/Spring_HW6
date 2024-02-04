package ru.kalenskiy.homework6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kalenskiy.homework6.model.Note;

import java.util.Optional;

/**
 * Класс репозитория
 */
@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
    /**
     * Метод получения объекта обертки заметки
     * @param id идентификатор заметки
     * @return объект-обертка класса заметка
     */
    Optional<Note> findById(Long id);
}
