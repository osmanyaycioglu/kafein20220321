package com.training.spring.rest.scope;


public class HelloScopeTesterProxy extends HelloScopeTester {

    @Override
    public String sayHello(final String nameParam) {
        System.out.println("From Proxy ...");
        return super.sayHello(nameParam);
    }

}
