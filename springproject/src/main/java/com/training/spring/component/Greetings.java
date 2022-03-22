package com.training.spring.component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("my-greeting-bean")
public class Greetings implements BeanNameAware {

    //Field Injection
    @Autowired
    private Hello        hello3;

    private final IHello hello;

    private Hello        hello2;

    //@Autowired
    private final EagerLazyTest eagerLazyTest;


    //Constructor Injection
    // @Autowired
    public Greetings(@Language("english") final IHello helloParam,
                     final EagerLazyTest eagerLazyTestParam) {
        super();
        this.hello = helloParam;
        this.eagerLazyTest = eagerLazyTestParam;
    }

    //Method Injection
    @Autowired
    public void abcWire(final Hello helloParam) {
        this.hello2 = helloParam;
    }

    @PostConstruct
    public void abcInit() {
        System.out.println("Greetings : PostConstruct...");
    }


    @PreDestroy
    public void abcDestroy() {
        System.out.println("Greetings : PreDestroy...");
    }


    public String greet(final String name) {
        return this.hello.sayHello(name);
    }

    @Override
    public void setBeanName(final String nameParam) {
        System.out.println("Greetings bean name : " + nameParam);
    }

}
