package com.training.spring.person.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.spring.models.Person;
import com.training.spring.person.data.PersonDataManager;

@Service
public class PersonQueryService {

    @Autowired
    private PersonDataManager personDataManager;

    public Person getSingle(final Long personIdParam) {
        return this.personDataManager.getSingle(personIdParam);
    }

    public List<Person> getAll() {
        return this.personDataManager.getAll();
    }

    public List<Person> getByName(final String nameParam) {
        return this.personDataManager.getByName(nameParam);

    }

}
