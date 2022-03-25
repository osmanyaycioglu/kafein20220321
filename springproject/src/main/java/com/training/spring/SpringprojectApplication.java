package com.training.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.training.spring.component.Greetings;
import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

@SpringBootApplication
//@SpringBootApplication(scanBasePackages = {
//                                           "com.training.spring",
//                                           "com.kafein.spring"
//})
@EnableScheduling
//@Import(KafeinConfig.class)
@EntityScan(basePackages = {
                             "com.training.spring",
                             "com.kafein.spring"
})
@EnableEncryptableProperties
@EnableAspectJAutoProxy
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
