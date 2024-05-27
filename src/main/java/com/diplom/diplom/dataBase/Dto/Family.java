package com.diplom.diplom.dataBase.Dto;

import lombok.Data;

@Data
public class Family {
    Integer parentId;
    String fio;
    Integer age;
    Float score;

    String parentFio;
    String child;
    Integer parentAge;
    String telephone;
    String address;
}
