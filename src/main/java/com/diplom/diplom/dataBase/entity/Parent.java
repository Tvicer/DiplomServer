package com.diplom.diplom.dataBase.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Parent")
public class Parent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String fio;
    private String child;
    private Integer age;
    private String telephone;
    private String address;
}
