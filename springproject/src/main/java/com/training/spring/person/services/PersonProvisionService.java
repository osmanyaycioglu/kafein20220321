package com.training.spring.person.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.spring.models.Person;
import com.training.spring.person.data.PersonDataManager;

@Service
public class PersonProvisionService {

    @Autowired
    private PersonDataManager personDataManager;

    public String add(final Person personParam) {
        this.personDataManager.insert(personParam);
        return "OK";
    }

}
