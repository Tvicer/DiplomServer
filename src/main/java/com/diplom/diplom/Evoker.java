package com.diplom.diplom;

import com.diplom.diplom.nlp.NlpService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Evoker {
    @Autowired
    NlpService nlpService;


    @EventListener(ApplicationReadyEvent.class)
    public void evoke() {
        //System.out.println(Double.valueOf(nlpService.sendToHandleNarration()));
        System.out.println("hi");
    }
}
