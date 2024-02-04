package ru.kalenskiy.homework6.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

/**
 * Класс заметки
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Note {
    /**
     * Идентифекатор заметки
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * Заголовок заметки
     */
    @Column(nullable = false)
    private String title;
    /**
     * Содержание заметки
     */
    @Column(nullable = false)
    private String content;
    /**
     * Дата и время создания заметки
     */
    @CreationTimestamp
    private LocalDateTime dateTimeOfCreated;


}
