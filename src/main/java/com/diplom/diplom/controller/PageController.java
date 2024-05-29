package com.diplom.diplom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
    @GetMapping("/auth")
    public String auth(){
        return "auth";
    }
    @GetMapping("/psychologist")
    public String psychologist(){
        return "psychologist";
    }
    @GetMapping("/parent")
    public String parent(){
        return "parent";
    }
    @GetMapping("/tests")
    public String tests(){
        return "tests";
    }
    @GetMapping("/test1")
    public String test1(){
        return "test1";
    }
}
