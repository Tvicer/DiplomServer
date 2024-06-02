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
    private String fio;
    private Integer childAge;
    private Integer parentAge;
    private String telephone;
    private String address;
    private String psychologist;
    private Integer groupNumber;
    private Boolean goodGroup;
    private Float result;
}
