package com.diplom.diplom;

import com.diplom.diplom.dataBase.service.UserService;
import com.diplom.diplom.nlp.service.NlpService;
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

    @Autowired
    UserService userService;

    @EventListener(ApplicationReadyEvent.class)
    public void evoke() {
        System.out.println("hi");
    }
}
