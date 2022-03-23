package com.training.spring.person.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.spring.person.rest.models.PersonRest;

@RestController
@RequestMapping("/api/v1/person/query")
public class PersonDataQueryController {

    @GetMapping("/get/single")
    public PersonRest getSingle(@RequestParam("perid") final Long personId) {
        return null;
    }

    @GetMapping("/get/all")
    public List<PersonRest> getAll() {
        return null;
    }

    @GetMapping("/get/by/name")
    public List<PersonRest> getByName(@RequestParam("name") final String name) {
        return null;
    }

}
