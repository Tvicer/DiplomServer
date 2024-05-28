package com.diplom.diplom.dataBase.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Child")
public class Child {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer parentId;
    private String fio;
    private Integer age;
    private Float score;
}
