package com.training.spring.rest.scope;

import com.training.spring.component.IHello;

public class HelloScopeTester implements IHello {

    private int counter = 0;

    @Override
    public String sayHello(final String nameParam) {
        this.counter++;
        return "Conter : " + this.counter + " test hello " + nameParam;
    }


}
