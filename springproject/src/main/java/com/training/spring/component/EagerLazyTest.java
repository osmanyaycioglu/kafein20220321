package com.training.spring.component;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
// @Lazy
public class EagerLazyTest {

    public EagerLazyTest() {
        System.out.println("EagerLazyTest yaratıldı");
    }

    @Scheduled(initialDelay = 2_000, fixedDelay = 2_000)
    public void xyz() {
        System.out.println("xyz");
    }

}
