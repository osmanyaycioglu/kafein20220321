package com.training.spring.component;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("espHello")
// @Primary
@Language("spanish")
public class HelloEsp implements IHello {

    @Override
    public String sayHello(final String name) {
        return "Ola " + name;
    }

}
