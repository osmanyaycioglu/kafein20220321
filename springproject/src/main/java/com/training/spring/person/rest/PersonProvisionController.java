package com.training.spring.person.rest;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.spring.person.rest.models.PersonRest;

@RestController
@RequestMapping("/api/v1/person/provision")
@Validated
public class PersonProvisionController {

    @PostMapping("/add")
    public String add(@Validated @RequestBody final PersonRest person) {
        //        if (person.getName() == null) {
        //            throw new IllegalArgumentException("name boş olamaz");
        //        }
        return "OK";
    }

    @GetMapping("/deactivate")
    public String deactivate(@NotNull @Positive @RequestParam("perid") final Long personId) {
        return "OK";
    }

    @GetMapping("/activate")
    public String activate(@NotNull @RequestParam("perid") final Long personId) {
        return "OK";
    }


}
