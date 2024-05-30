package com.diplom.diplom.voiceToText;

import com.diplom.diplom.dataBase.repository.ChildRepository;
import com.diplom.diplom.nlp.NlpClientDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VoiceToTextService {
    @Autowired
    private final VoiceToTextFeignClient voiceToTextFeignClient;

    @Autowired
    private final ChildRepository childRepository;

    public String sendToHandleNarration(NlpClientDto request) {
        return "";
    }

}
