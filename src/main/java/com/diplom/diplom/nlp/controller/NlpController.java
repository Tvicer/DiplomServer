package com.diplom.diplom.nlp.controller;

import com.diplom.diplom.nlp.dto.NlpClientDto;
import com.diplom.diplom.nlp.dto.NlpClientToDbDto;
import com.diplom.diplom.nlp.service.NlpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@Controller
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RequestMapping(path = "/nlp")
public class NlpController {
    @Autowired
    private NlpService nlpService;

    @GetMapping(path = "/ping", produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('ROLE_PSYCHOLOGIST')")
    public ResponseEntity getOk() {
        return new ResponseEntity<>("ok", HttpStatus.OK);
    }

    @PostMapping(path = "/sendToNlp", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('ROLE_PSYCHOLOGIST')")
    public ResponseEntity sendDataToNlp(@RequestBody @Validated NlpClientDto request) {
        double result = Double.parseDouble(nlpService.sendToHandleNarration(request));
        var ans = new HashMap<String, Integer>();
        ans.put("answer", (int)(result * 100));
        return new ResponseEntity(ans, HttpStatus.OK);
    }

}

