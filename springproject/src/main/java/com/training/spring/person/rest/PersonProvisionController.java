package com.training.spring.person.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.spring.person.rest.models.PersonRest;

@RestController
@RequestMapping("/api/v1/person/provision")
public class PersonProvisionController {

    @PostMapping("/add")
    public String add(@RequestBody final PersonRest person) {
        return "OK";
    }

    @GetMapping("/deactivate")
    public String deactivate(@RequestParam("perid") final Long personId) {
        return "OK";
    }

    @GetMapping("/activate")
    public String activate(@RequestParam("perid") final Long personId) {
        return "OK";
    }

}
