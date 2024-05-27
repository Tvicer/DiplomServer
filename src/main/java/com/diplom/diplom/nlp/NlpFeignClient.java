package com.diplom.diplom.nlp;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "nlp", url = "http://127.0.0.1:5000", configuration = FeignConfig.class)
public interface NlpFeignClient {
    @PostMapping(value = "/api/nlp", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    String sendNarration(@RequestBody NlpFeignDto body);
}
