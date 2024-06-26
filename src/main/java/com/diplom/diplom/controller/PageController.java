package com.diplom.diplom.controller;

import com.diplom.diplom.dataBase.entity.User;
import com.diplom.diplom.dataBase.service.UserService;
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
        userService.createUser(user);
        return "redirect:/login";
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }

    @PostMapping("/admin")
    public String createAdmin(User user) {
        userService.createPsychologist(user);
        return "redirect:/login";
    }

    @GetMapping("/parent")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public String parent() {
        return "parent";
    }

    @GetMapping("/info")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public String info() {
        return "info";
    }

    @GetMapping("/parent-schedule")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public String parentSchedule() {
        return "parent-schedule";
    }

    @GetMapping("/psychologist")
    @PreAuthorize("hasRole('ROLE_PSYCHOLOGIST') or hasRole('ROLE_ADMIN')")
    public String psychologist() {
        return "psychologist";
    }

    @GetMapping("/childs")
    @PreAuthorize("hasRole('ROLE_PSYCHOLOGIST') or hasRole('ROLE_ADMIN')")
    public String childs() {
        return "childs";
    }

    @GetMapping("/psychologist-schedule")
    @PreAuthorize("hasRole('ROLE_PSYCHOLOGIST') or hasRole('ROLE_ADMIN')")
    public String psychologistSchedule() {
        return "psychologist-schedule";
    }

    @GetMapping("/tests")
    @PreAuthorize("hasRole('ROLE_PSYCHOLOGIST') or hasRole('ROLE_ADMIN')")
    public String tests() {
        return "tests";
    }

    @GetMapping("/test1")
    @PreAuthorize("hasRole('ROLE_PSYCHOLOGIST') or hasRole('ROLE_ADMIN')")
    public String test1() {
        return "test1";
    }
}
