package com.diplom.diplom.nlp.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class NlpClientToDbDto {
    String fio;
    Integer childAge;
    String parentFio;
    Integer parentAge;
    String telephone;
    String address;
    Float result;
}
