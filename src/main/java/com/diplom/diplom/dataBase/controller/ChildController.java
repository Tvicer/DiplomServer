package com.diplom.diplom.dataBase.controller;

import com.diplom.diplom.dataBase.Dto.Family;
import com.diplom.diplom.dataBase.entity.Child;
import com.diplom.diplom.dataBase.service.FamilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@Controller
@RequestMapping(path = "/child")
public class ChildController {
    @Autowired
    private FamilyService familyService;

    @GetMapping(path = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Child> getAllChilds() {
        return familyService.getAllChilds();
    }

    @GetMapping(path = "/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Child> getAllChilds(@RequestParam(value = "id") Integer id) {
        return familyService.getAllChilds(id);
    }

    @PostMapping(path = "/post", produces = MediaType.APPLICATION_JSON_VALUE)
    public void postChild(@RequestBody Family request) {

    }


}
