package com.training.spring.aop;

import org.springframework.stereotype.Component;

@Component
public class SecondBean {

    public String hello(final String name) {
        return "Hello " + name;
    }

}
