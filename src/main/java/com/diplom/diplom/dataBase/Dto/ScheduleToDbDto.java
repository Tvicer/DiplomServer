package com.diplom.diplom.dataBase.Dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ScheduleToDbDto {
    private String psychologistEmail;

    private Integer day;

    private Integer month;

    private Integer year;

    private Integer minute;

    private Integer hour;
}
