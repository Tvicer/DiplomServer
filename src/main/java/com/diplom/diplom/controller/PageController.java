package com.diplom.diplom.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class PageController {
    @GetMapping("/auth")
    public String auth(){
        return "auth";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }
    @GetMapping("/psychologist")
    //@PreAuthorize("ROLE_PSYCHOLOGIST")
    public String psychologist(){
        return "psychologist";
    }
    @GetMapping("/parent")
    //@PreAuthorize("ROLE_USER")
    public String parent(){
        return "parent";
    }
    @GetMapping("/tests")
    //@PreAuthorize("ROLE_PSYCHOLOGIST")
    public String tests(){
        return "tests";
    }
    @GetMapping("/test1")
    //@PreAuthorize("ROLE_PSYCHOLOGIST")
    public String test1(){
        return "test1";
    }
}
