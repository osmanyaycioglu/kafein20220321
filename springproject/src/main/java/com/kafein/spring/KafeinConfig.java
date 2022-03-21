package com.kafein.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafeinConfig {

    @Bean
    public AnyBean anyBean() {
        return new AnyBean();
    }

}
