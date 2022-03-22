package com.training.spring.profile;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.training.spring.component.Hello;
import com.training.spring.component.HelloWithPrefix;
import com.training.spring.component.IHello;

@Configuration
@Profile("eng")
public class EnglishLangConf {

    @Bean
    public IHello helloLaguage() {
        return new Hello();
    }

    @Bean
    public IHello helloLaguageDynamic(@Value("${application.info.hello.prefix}") final String prefix) {
        return new HelloWithPrefix(prefix);
    }
}
