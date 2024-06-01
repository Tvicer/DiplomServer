package com.diplom.diplom.nlp.service;

import com.diplom.diplom.dataBase.entity.Child;
import com.diplom.diplom.dataBase.repository.ChildRepository;
import com.diplom.diplom.nlp.dto.NlpClientDto;
import com.diplom.diplom.nlp.feign.NlpFeignClient;
import com.diplom.diplom.nlp.dto.NlpClientToDbDto;
import com.diplom.diplom.nlp.dto.NlpFeignDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NlpService {
    @Autowired
    private final NlpFeignClient nlpFeignClient;

    @Autowired
    private final ChildRepository childRepository;

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

    public String sendToHandleNarration(NlpClientDto request) {
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

    public void sendToDb(NlpClientToDbDto request) {
        Child child = new Child();
        child.setFio(request.getFio());
        child.setChildAge(request.getChildAge());
        child.setParentAge(request.getParentAge());
        child.setTelephone(request.getTelephone());
        child.setAddress(request.getAddress());
        child.setResult(request.getResult());
        childRepository.save(child);
    }
}
