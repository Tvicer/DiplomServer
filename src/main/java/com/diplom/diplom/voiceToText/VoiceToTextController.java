package com.diplom.diplom.voiceToText;

import com.diplom.diplom.nlp.NlpClientDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RequestMapping(path = "/voiceToText")
public class VoiceToTextController {
    @Autowired
    private VoiceToTextService voiceToTextService;

    @PostMapping(path = "/send", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity sendData(@RequestBody @Validated NlpClientDto request) {
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

