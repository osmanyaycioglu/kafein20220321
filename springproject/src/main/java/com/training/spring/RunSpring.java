package com.training.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.training.spring.component.Greetings;
import com.training.spring.component.Hello;

public class RunSpring {

    public static void main(final String[] args) {
        ConfigurableApplicationContext contextLoc = SpringApplication.run(SpringprojectApplication.class,
                                                                          args);
        Hello helloLoc = new Hello();
        System.out.println("Result  + " + helloLoc.sayHello("osman"));
        //        SpringprojectApplication applicationLoc = new SpringprojectApplication();
        //        String greetLoc = applicationLoc.greetings.greet("osman");
        SpringprojectApplication beanLoc = contextLoc.getBean(SpringprojectApplication.class);
        String greetLoc = beanLoc.getGreetings()
                                 .greet("osman");
        Greetings bean2Loc = (Greetings) contextLoc.getBean("my-greeting-bean");
        System.out.println("----------OUT : " + greetLoc);
        System.out.println("----------OUT2 : " + bean2Loc.greet("ali"));

    }

}
