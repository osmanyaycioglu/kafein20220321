package com.training.spring.person.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.spring.person.rest.mappers.IPersonMapper;
import com.training.spring.person.rest.models.PersonRest;
import com.training.spring.person.services.PersonProvisionService;

@RestController
@RequestMapping("/api/v1/person/management")
public class PersonDataManagementController {

    @Autowired
    private PersonProvisionService pps;


    @PostMapping("/update")
    public String update(@RequestBody final PersonRest person) {
        return this.pps.update(IPersonMapper.personMapper.toPerson(person));
    }

}
