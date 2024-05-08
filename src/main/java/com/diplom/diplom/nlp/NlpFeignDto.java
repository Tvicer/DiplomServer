package com.diplom.diplom.nlp;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NlpFeignDto {
    String order1;
    String time1;
    String tell1;

    String order2;
    String time2;
    String tell2;

    String time3;
    String tell3;
}
