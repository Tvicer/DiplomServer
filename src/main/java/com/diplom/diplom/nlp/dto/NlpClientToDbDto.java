package com.diplom.diplom.nlp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class NlpClientToDbDto {
    String fio;
    String childAge;
    String parentAge;
    String telephone;
    String address;
    Float result;
}
