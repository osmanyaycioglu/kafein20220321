package com.training.spring.person.data;

import java.util.ArrayList;
import java.util.List;

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

    public void update(final Person personParam) {
        this.personDao.save(personParam);
    }

    public Person getSingle(final Long personIdParam) {
        return this.personDao.findById(personIdParam)
                             .orElse(null);
    }

    public List<Person> getAll() {
        List<Person> listLoc = new ArrayList<>();
        Iterable<Person> findAllLoc = this.personDao.findAll();
        for (Person personLoc : findAllLoc) {
            listLoc.add(personLoc);
        }
        return listLoc;
    }

    public List<Person> getByName(final String nameParam) {
        return this.personDao.findByName(nameParam);
    }

}
