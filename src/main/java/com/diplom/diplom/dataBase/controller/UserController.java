package com.diplom.diplom.dataBase.controller;

import com.diplom.diplom.dataBase.Dto.ScheduleToDbDto;
import com.diplom.diplom.dataBase.service.ScheduleService;
import com.diplom.diplom.dataBase.service.UserService;
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


@Controller
@RequestMapping(path = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(path = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity getPsychologist() {
        return new ResponseEntity(userService.getPsychologist(), HttpStatus.OK);
    }


}
