package com.diplom.diplom.voiceToText;

import com.diplom.diplom.nlp.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "voiceToText", url = "http://127.0.0.1:5000", configuration = FeignConfig.class)
public interface VoiceToTextFeignClient {
    @PostMapping(value = "/api/voiceTOText", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    String sendNarration(@RequestBody NlpFeignDto body);
}
