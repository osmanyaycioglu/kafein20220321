package com.training.spring.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FirstBean {

    @Autowired
    private SecondBean secondBean;

    public void greet(final String stringParam) {
        System.out.println(this.secondBean.hello(stringParam));
    }
}
