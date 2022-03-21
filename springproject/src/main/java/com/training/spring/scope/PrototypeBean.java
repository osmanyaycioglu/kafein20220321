package com.training.spring.scope;

public class PrototypeBean {

    private long counter = 0;


    public PrototypeBean() {
        System.out.println("------CREATED : PrototypeBean ");
    }

    public void doIt() {
        this.counter++;
        System.out.println("Prototype Counter : " + this.counter);
    }

}
