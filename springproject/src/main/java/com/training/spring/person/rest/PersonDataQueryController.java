package com.training.spring.person.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.spring.person.rest.mappers.IPersonMapper;
import com.training.spring.person.rest.models.PersonRest;
import com.training.spring.person.services.PersonQueryService;

@RestController
@RequestMapping("/api/v1/person/query")
public class PersonDataQueryController {

    @Autowired
    private PersonQueryService pqs;

    @GetMapping("/get/single")
    public PersonRest getSingle(@RequestParam("perid") final Long personId) {
        return IPersonMapper.personMapper.fromPerson(this.pqs.getSingle(personId));
    }

    @GetMapping("/get/all")
    public List<PersonRest> getAll() {
        return IPersonMapper.personMapper.fromPersons(this.pqs.getAll());
    }

    @GetMapping("/get/by/name")
    public List<PersonRest> getByName(@RequestParam("name") final String name) {
        return IPersonMapper.personMapper.fromPersons(this.pqs.getByName(name));
    }

}
