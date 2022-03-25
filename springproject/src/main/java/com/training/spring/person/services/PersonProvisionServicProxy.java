package com.training.spring.person.services;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Service;

import com.training.spring.models.Person;

@Service
public class PersonProvisionServicProxy extends PersonProvisionService {


    @Override
    public String add(final Person personParam) {
        EntityManager entityManagerLoc = null;
        entityManagerLoc.getTransaction()
                        .begin();
        try {
            String addLoc = super.add(personParam);
            entityManagerLoc.getTransaction()
                            .commit();
            return addLoc;
        } catch (Exception eLoc) {
            entityManagerLoc.getTransaction()
                            .rollback();
        }
        return null;
    }

    @Override
    public String update(final Person personParam) {
        return super.update(personParam);
    }

}
