package com.diplom.diplom.nlp;

import feign.Request;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {
    @Bean
    public Request.Options options() {
        return new Request.Options(6000000, 6000000);
    }
}
