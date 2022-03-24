package com.training.spring.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

import com.training.spring.models.Person;

@Component
public class MyHealth implements HealthIndicator {

    @Override
    public Health health() {
        Person personLoc = new Person();
        personLoc.setName("osman");
        personLoc.setSurname("ayay");
        return Health.status(Status.UP)
                     .withDetail("problem yok",
                                 personLoc)
                     .build();
    }

}
