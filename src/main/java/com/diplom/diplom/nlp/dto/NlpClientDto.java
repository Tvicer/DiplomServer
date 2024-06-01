package com.diplom.diplom.nlp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class NlpClientDto {
    @JsonProperty(value = "tell1")
    public String tell1;

    @JsonProperty(value = "tell2")
    public String tell2;

    @JsonProperty(value = "tell3")
    public String tell3;
}
