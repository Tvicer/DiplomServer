package com.diplom.diplom.nlp;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class NlpClientDto {
    @JsonProperty(value = "tell1")
    String tell1;

    @JsonProperty(value = "tell2")
    String tell2;

    @JsonProperty(value = "tell3")
    String tell3;
}
