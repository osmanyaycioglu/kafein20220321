package com.training.spring.singleton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.training.spring.core.confprop.Person;

@Service
public class PersonManager {

    private final Map<String, Person> personMap  = new ConcurrentHashMap<>();
    //    private final List<Person>        personList = new Vector<>();
    private final List<Person>        personList = Collections.synchronizedList(new ArrayList<>());
    private final AtomicLong          counter    = new AtomicLong();

    public void addPerson(final Person personParam) {
        this.counter.incrementAndGet();
        this.personMap.put(personParam.getName() + "_" + personParam.getSurname(),
                           personParam);
    }

    public void xyz() {
        List<Person> listLoc = new ArrayList<>();
    }

}
