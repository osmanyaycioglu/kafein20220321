package com.training.spring.component;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("engHello")
@Language("english")
// @Lazy
public class Hello implements IHello {

    @Override
    public String sayHello(final String name) {
        return "Hello " + name;
    }

}
