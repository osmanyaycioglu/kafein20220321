package com.training.spring.person.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.training.spring.models.Person;
import com.training.spring.person.data.PersonDataManager;

@Service
public class PersonProvisionService {

    @Autowired
    private PersonDataManager personDataManager;

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.SERIALIZABLE)
    public String add(final Person personParam) {
        this.personDataManager.insert(personParam);
        this.personDataManager.insertCredential(personParam);
        return "OK";
    }

    public String update(final Person personParam) {
        this.personDataManager.update(personParam);
        return "OK";
    }

}
