package com.diplom.diplom.nlp;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NlpService {
    @Autowired
    private final NlpFeignClient nlpFeignClient;

    public String sendToHandleTestNarration() {
        return nlpFeignClient.sendNarration(NlpFeignDto.builder()
                .tell1("мальчик поставил красный кубик, еще один мальчик только начал, а следующий заплакал")
                .tell2("котенок уронил цветок сюда, этот котенок уже уронил, а этот котенок хочет достать цветок")
                .tell3("дочка уронила чашку, а тут .. тут мальчик взял блюдце")
                .order1("213")
                .order2("123")
                .time1("11")
                .time2("21")
                .time3("15")
                .build());
    }

    public String sendToHandleNarration(NlpFeignDto request) {
        return nlpFeignClient.sendNarration(NlpFeignDto.builder()
                .tell1(request.tell1)
                .tell2(request.tell2)
                .tell3(request.tell3)
                .order1("213")
                .order2("123")
                .time1("11")
                .time2("21")
                .time3("15")
                .build());
    }
}
