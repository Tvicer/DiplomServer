package com.diplom.diplom.dataBase.Dto;

import lombok.Data;

@Data
public class ScheduleDto {
    private Long id;

    private String parentFio;

    private String parentEmail;

    private String psychologistEmail;

    private String dateTime;
}
