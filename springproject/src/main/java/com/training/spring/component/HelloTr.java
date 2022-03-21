package com.training.spring.component;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("trHello")
@Language("turkish")
// @Primary
// @Lazy
public class HelloTr implements IHello {

    @Override
    public String sayHello(final String name) {
        return "Merhaba " + name;
    }

}
