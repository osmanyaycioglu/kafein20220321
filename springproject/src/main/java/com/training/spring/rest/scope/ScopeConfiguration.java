package com.training.spring.rest.scope;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;

import com.training.spring.component.IHello;
import com.training.spring.component.Language;

@Configuration
public class ScopeConfiguration {

    @Bean
    @Language("hello-tester")
    //@Scope("singleton")
    @SessionScope
    public IHello helloCreator() {
        return new HelloScopeTester();
    }

}
