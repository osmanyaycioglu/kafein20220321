package com.training.spring.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class RunAOP implements CommandLineRunner {

    @Autowired
    private FirstBean fb;

    @Override
    public void run(final String... argsParam) throws Exception {
        this.fb.greet("mehmet");
    }

}
