package com.training.spring.person.rest;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.spring.person.rest.mappers.IPersonMapper;
import com.training.spring.person.rest.models.PersonRest;
import com.training.spring.person.services.PersonProvisionService;

@RestController
@RequestMapping("/api/v1/person/provision")
@Validated
public class PersonProvisionController {

    @Autowired
    private PersonProvisionService pps;

    @PostMapping("/add")
    public String add(@Validated @RequestBody final PersonRest person) {
        //        if (person.getName() == null) {
        //            throw new IllegalArgumentException("name boş olamaz");
        //        }

        return this.pps.add(IPersonMapper.personMapper.toPerson(person,
                                                                IPersonMapper.personMapper.toPersonCredential(person)));
    }

    @GetMapping("/deactivate")
    public String deactivate(@NotNull @Positive @RequestParam("perid") final Long personId) {
        return "OK";
    }

    @GetMapping("/activate")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public String activate(@NotNull @RequestParam("perid") final Long personId) {
        return "OK";
    }


}
