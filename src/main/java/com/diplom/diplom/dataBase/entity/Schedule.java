package com.diplom.diplom.dataBase.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "schedule")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String parentFio;

    private String parentEmail;

    private String psychologistEmail;

    @Column(unique = true)
    private LocalDateTime dateTime;
}
