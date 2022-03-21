package com.training.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.training.spring.component.Greetings;

@SpringBootApplication
//@SpringBootApplication(scanBasePackages = {
//                                           "com.training.spring",
//                                           "com.kafein.spring"
//})
@EnableScheduling
//@Import(KafeinConfig.class)
public class SpringprojectApplication {

    @Autowired
    private Greetings greetings;

    public Greetings getGreetings() {
        return this.greetings;
    }

    public void setGreetings(final Greetings greetingsParam) {
        this.greetings = greetingsParam;
    }


}
