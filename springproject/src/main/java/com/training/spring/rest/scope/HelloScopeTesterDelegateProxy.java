package com.training.spring.rest.scope;


public class HelloScopeTesterDelegateProxy extends HelloScopeTester {

    private final HelloScopeTester hello;

    public HelloScopeTesterDelegateProxy(final HelloScopeTester helloParam) {
        super();
        this.hello = helloParam;
    }

    @Override
    public String sayHello(final String nameParam) {
        System.out.println("From Proxy ...");
        return this.hello.sayHello(nameParam);
    }

}
