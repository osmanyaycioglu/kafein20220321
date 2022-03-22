package com.training.spring.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.training.spring.component.IHello;

@Component
public class ProfileRunner implements CommandLineRunner {

    @Autowired
    @Qualifier("helloLaguage")
    private IHello helloLang;

    @Autowired
    @Qualifier("helloLaguageDynamic")
    private IHello helloDynamicLang;

    @Override
    public void run(final String... argsParam) throws Exception {
        System.out.println("====================0=========================");
        System.out.println(this.helloLang.sayHello("orhan"));
        System.out.println(this.helloDynamicLang.sayHello("ayşe"));
        System.out.println("====================0=========================");
    }


}
