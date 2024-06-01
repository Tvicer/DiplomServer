package com.diplom.diplom.voiceToText.service;

import com.diplom.diplom.voiceToText.feign.VoiceToTextFeignClient;
import com.diplom.diplom.voiceToText.dto.VoiceToTextDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VoiceToTextService {
    @Autowired
    private final VoiceToTextFeignClient voiceToTextFeignClient;


    public String sendToVoiceToText(VoiceToTextDto request) {
        var voice = new VoiceToTextDto();
        voice.setVoice(request.getVoice());
        return voiceToTextFeignClient.sendVoice(voice);
    }

}
