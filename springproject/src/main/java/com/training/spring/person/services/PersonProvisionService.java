package com.training.spring.person.services;

import org.springframework.stereotype.Service;

import com.training.spring.core.confprop.Person;

@Service
public class PersonProvisionService {

    public String add(final Person personParam) {
        return "OK";
    }

}
