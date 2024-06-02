package com.diplom.diplom.dataBase.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "fio")
    private String fio;

    @Column(name = "password", length = 1000)
    private String password;

    private String role;

}
