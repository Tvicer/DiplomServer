package com.diplom.diplom.nlp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity getOk() {
        return new ResponseEntity<>("ok", HttpStatus.OK);
    }

    @PostMapping(path = "/send", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity sendDataToNlp(@RequestBody @Validated NlpClientDto request) {
        //return nlpService.sendToHandle1Narration(request.tell1);
        var ans = new HashMap<String, String>();
        ans.put("answer", "0.999");
        return new ResponseEntity(ans, HttpStatus.OK);
    }

}

