package com.diplom.diplom.dataBase.controller;

import com.diplom.diplom.dataBase.Dto.Family;
import com.diplom.diplom.dataBase.entity.Child;
import com.diplom.diplom.dataBase.service.ChildService;
import com.diplom.diplom.nlp.dto.NlpClientToDbDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;


@Controller
@RequestMapping(path = "/child")
public class ChildController {
    @Autowired
    private ChildService childService;

    @GetMapping(path = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('ROLE_PSYCHOLOGIST')")
    public ResponseEntity<Iterable<Child>> getAllChilds() {
        return new ResponseEntity<Iterable<Child>>(childService.getAllChilds(), HttpStatus.OK);
    }

    @GetMapping(path = "/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('ROLE_PSYCHOLOGIST')")
    public Optional<Child> getChildById(@RequestParam(value = "id") Integer id) {
        return childService.getChildById(id);
    }

    @PostMapping(path = "/post", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('ROLE_PSYCHOLOGIST')")
    public ResponseEntity sendDataToDb(@RequestBody @Validated NlpClientToDbDto request) {
        childService.sendChild(request);
        return new ResponseEntity(HttpStatus.OK);
    }


}
