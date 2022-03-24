package com.training.spring.person.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.spring.models.Person;
import com.training.spring.person.data.repository.IPersonDao;

@Service
public class PersonDataManager {

    @Autowired
    private IPersonDao personDao;

    public void insert(final Person personParam) {
        this.personDao.save(personParam);
    }

}
