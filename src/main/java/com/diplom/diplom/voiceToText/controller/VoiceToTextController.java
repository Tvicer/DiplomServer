package com.diplom.diplom.voiceToText.controller;

import com.diplom.diplom.voiceToText.dto.VoiceToTextDto;
import com.diplom.diplom.voiceToText.service.VoiceToTextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;

@Controller
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RequestMapping(path = "/voiceToText")
public class VoiceToTextController {
    @Autowired
    private VoiceToTextService voiceToTextService;

    @PostMapping(path = "/send", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity sendData(@RequestBody VoiceToTextDto request) throws InterruptedException {
        Thread.sleep(1000);
        var result = voiceToTextService.sendToVoiceToText(request);
        System.out.println(result);
        var ans = new HashMap<String, String>();
        ans.put("answer", result);
        return new ResponseEntity<>(ans, HttpStatus.OK);
    }

}

