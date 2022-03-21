package com.training.spring.component;

public class HelloWithPrefix implements IHello {

    private final String prefix;

    public HelloWithPrefix(final String prefixParam) {
        super();
        this.prefix = prefixParam;
    }

    @Override
    public String sayHello(final String name) {
        return this.prefix + " " + name;
    }

}
