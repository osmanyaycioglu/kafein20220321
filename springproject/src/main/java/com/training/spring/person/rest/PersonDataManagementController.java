package com.training.spring.person.rest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.spring.person.rest.models.PersonRest;

@RestController
@RequestMapping("/api/v1/person/management")
public class PersonDataManagementController {

    @PostMapping("/update")
    public String update(@RequestBody final PersonRest person) {
        return "OK";
    }

}
