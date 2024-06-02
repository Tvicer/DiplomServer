package com.diplom.diplom.dataBase.controller;

import com.diplom.diplom.dataBase.Dto.ScheduleDto;
import com.diplom.diplom.dataBase.Dto.ScheduleToDbDto;
import com.diplom.diplom.dataBase.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.LinkedList;


@Controller
@RequestMapping(path = "/schedule")
public class ScheduleController {
    @Autowired
    private ScheduleService scheduleService;

    @GetMapping(path = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('ROLE_PSYCHOLOGIST')")
    public ResponseEntity<LinkedList<ScheduleDto>> getScheduleByPsychologist() {
        return new ResponseEntity<LinkedList<ScheduleDto>>(scheduleService.getScheduleByPsychologist(), HttpStatus.OK);
    }

    @PostMapping(path = "/post", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity sendDataToDb(@RequestBody ScheduleToDbDto request) {
        scheduleService.sendSchedule(request);
        return new ResponseEntity(HttpStatus.OK);
    }
}
