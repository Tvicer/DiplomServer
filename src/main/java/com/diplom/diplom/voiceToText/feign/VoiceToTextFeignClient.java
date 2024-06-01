package com.diplom.diplom.voiceToText.feign;

import com.diplom.diplom.nlp.config.FeignConfig;
import com.diplom.diplom.voiceToText.dto.VoiceToTextDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "voiceToText", url = "http://127.0.0.1:3000", configuration = FeignConfig.class)
public interface VoiceToTextFeignClient {
    @PostMapping(value = "/api/voiceToText/send", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    String sendVoice(@RequestBody VoiceToTextDto body);
}
