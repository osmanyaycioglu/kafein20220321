package com.training.spring.person.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.training.spring.models.Person;
import com.training.spring.person.data.repository.IPersonCredentialDao;
import com.training.spring.person.data.repository.IPersonDao;

@Service
public class PersonDataManager {

    @Autowired
    private IPersonDao           personDao;

    @Autowired
    private IPersonCredentialDao personCredentialDao;

    @Transactional(propagation = Propagation.REQUIRED)
    public Person insert(final Person personParam) {
        return this.personDao.save(personParam);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void insertCredential(final Person personParam) {
        this.personCredentialDao.save(personParam.getPersonCredential());
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
