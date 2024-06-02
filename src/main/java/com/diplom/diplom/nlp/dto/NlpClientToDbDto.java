package com.diplom.diplom.nlp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class NlpClientToDbDto {
    String fio;
    Integer childAge;
    Integer parentAge;
    String telephone;
    String address;
    Float result;
}
