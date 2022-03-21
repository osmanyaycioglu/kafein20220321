package com.training.spring.scope;

public class SingletonBean {

    private long counter = 0;


    public synchronized void increase() {
        this.counter++;
    }

    public SingletonBean() {
        System.out.println("------CREATED : SingletonBean ");
    }


    public void doIt() {
        this.increase();
        System.out.println("Singleton Counter : " + this.counter);
    }

}
