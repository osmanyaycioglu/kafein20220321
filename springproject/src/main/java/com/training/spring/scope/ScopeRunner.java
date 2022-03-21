package com.training.spring.scope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ScopeRunner implements CommandLineRunner {

    @Autowired
    private SingletonBean sb1;
    @Autowired
    private SingletonBean sb2;
    @Autowired
    private SingletonBean sb3;
    @Autowired
    private SingletonBean sb4;
    @Autowired
    private SingletonBean sb5;

    @Autowired
    private PrototypeBean pb1;
    @Autowired
    private PrototypeBean pb2;
    @Autowired
    private PrototypeBean pb3;
    @Autowired
    private PrototypeBean pb4;
    @Autowired
    private PrototypeBean pb5;


    @Override
    public void run(final String... argsParam) throws Exception {
        this.sb1.doIt();
        this.sb1.doIt();
        this.sb2.doIt();
        this.sb2.doIt();
        this.sb3.doIt();
        this.sb3.doIt();
        this.sb4.doIt();
        this.sb4.doIt();
        this.sb5.doIt();
        this.sb5.doIt();
        System.out.println("-------------");
        this.pb1.doIt();
        this.pb1.doIt();
        this.pb2.doIt();
        this.pb2.doIt();
        this.pb3.doIt();
        this.pb3.doIt();
        this.pb4.doIt();
        this.pb4.doIt();
        this.pb5.doIt();
        this.pb5.doIt();

    }

}
