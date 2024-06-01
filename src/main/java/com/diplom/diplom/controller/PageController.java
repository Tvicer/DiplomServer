package com.diplom.diplom.controller;

import com.diplom.diplom.dataBase.entity.User;
import com.diplom.diplom.dataBase.service.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class PageController {
    @Autowired
    UserService userService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String createUser(User user) {
        System.out.println(user.getEmail());
        userService.createUser(user);
        return "redirect:/login";
    }
    @GetMapping("/parent")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String parent(){
        return "parent";
    }
    @GetMapping("/psychologist")
    @PreAuthorize("hasRole('ROLE_PSYCHOLOGIST')")
    public String psychologist(){
        return "psychologist";
    }
    @GetMapping("/childs")
    @PreAuthorize("hasRole('ROLE_PSYCHOLOGIST')")
    public String childs(){
        return "childs";
    }
    @GetMapping("/tests")
    @PreAuthorize("hasRole('ROLE_PSYCHOLOGIST')")
    public String tests(){
        return "tests";
    }
    @GetMapping("/test1")
    @PreAuthorize("hasRole('ROLE_PSYCHOLOGIST')")
    public String test1(){
        return "test1";
    }
}
