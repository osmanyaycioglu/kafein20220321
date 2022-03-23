package com.training.spring.rest;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.training.spring.core.confprop.Person;

// @Controller // MVC demek Controller -> View , Method String dönerse Hello.jsp render olur ve client a döner
// @ResponseBody
@RestController
@RequestMapping("/rest")
public class HelloRest {

    // /rest/hello2?xyz=NNNNN&abc=SSSSS
    @GetMapping(value = "/hello2")
    public String hello2(@RequestParam("xyz") final String name,
                         @RequestParam("abc") final String surname) {
        return "Hello 2 " + name + " " + surname;
    }

    // /rest/hello3/NNNNN/SSSSS
    @GetMapping(value = "/hello3/{xyz}/{abc}")
    public String hello3(@PathVariable("xyz") final String name,
                         @PathVariable("abc") final String surname) {
        return "Hello 3 " + name + " " + surname;
    }

    // /rest/hello4/NNNNN?soy=SSSSS
    @GetMapping(value = "/hello4/{isim}")
    public String hello4(@PathVariable("isim") final String name,
                         @RequestParam("soy") final String surname) {
        return "Hello 4 " + name + " " + surname;
    }

    @PostMapping("/hello5")
    public String hello5(@RequestBody final Person personParam) {
        return "Hello 5 " + personParam;
    }

    @PostMapping("/hello6")
    public HelloPostResponse hello6(@RequestBody final Person personParam) {
        HelloPostResponse responseLoc = new HelloPostResponse();
        responseLoc.setPerson(personParam);
        responseLoc.setDesc("öyle böyle");
        responseLoc.setVersion("1.0.1");
        return responseLoc;
    }

    @GetMapping(value = "/hello7")
    public String hello7(@RequestHeader("xyz") final String name,
                         @RequestHeader("abc") final String surname) {
        return "Hello 7 " + name + " " + surname;
    }

    @PostMapping("/hello8")
    public ResponseEntity<String> hello8(@RequestBody final Person personParam) {
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                             .header("test",
                                     "custom header")
                             .body("Hello 8 " + personParam);
    }

    @PostMapping("/hello9")
    public ResponseEntity<String> xyz(final HttpServletRequest httpServletRequest) throws Exception {
        ServletInputStream inputStreamLoc = httpServletRequest.getInputStream();
        ObjectMapper objectMapper = new ObjectMapper();
        Person person = objectMapper.readValue(inputStreamLoc,
                                               Person.class);
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                             .header("test",
                                     "custom header")
                             .body("Hello 9 " + person);
    }

    @PostMapping("/person/add")
    public ResponseEntity<Person> add(@RequestParam("personId") final Long personId) throws Exception {
        Person personLoc = new Person();
        personLoc.setName("test");
        personLoc.setSurname("xyz");
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                             .header("test",
                                     "custom header")
                             .header("Content-Type",
                                     "application/json")
                             .body(personLoc);
    }

    // Bunu yapma
    @PostMapping("/dyn/person/{operation}")
    public ResponseEntity<?> xyz(@PathVariable("operation") final String operation,
                                 final HttpServletRequest httpServletRequest) throws Exception {
        switch (operation) {
            case "add":
                String parameterLoc = httpServletRequest.getParameter("personId");
                long parseLongLoc = Long.parseLong(parameterLoc);
                // Person ara
                Person personLoc = new Person();
                personLoc.setName("test");
                personLoc.setSurname("xyz");
                return ResponseEntity.status(HttpStatus.ACCEPTED)
                                     .header("test",
                                             "custom header")
                                     .header("Content-Type",
                                             "application/json")
                                     .body(personLoc);
            case "show":
                ServletInputStream inputStreamLoc = httpServletRequest.getInputStream();
                ObjectMapper objectMapper = new ObjectMapper();
                Person person = objectMapper.readValue(inputStreamLoc,
                                                       Person.class);
                return ResponseEntity.status(HttpStatus.ACCEPTED)
                                     .header("test",
                                             "custom header")
                                     .body("Hello 9 " + person);

        }
        throw new IllegalStateException("Bilinmeyen operasyon");
    }


    // /rest/hello/hello GET Methodu
    // @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @GetMapping(value = "/hello")
    public String helloGET() {
        return "Hello GET";
    }

    @PostMapping("/hello")
    public String helloPOST() {
        return "Hello POST";
    }

    @PutMapping("/hello")
    public String helloPUT() {
        return "Hello PUT";
    }

    @DeleteMapping("/hello")
    public String helloDelete() {
        return "Hello DELETE";
    }

    @PatchMapping("/hello")
    public String helloPatch() {
        return "Hello PATCH";
    }

    @GetMapping("/hello1")
    public String hello1GET() {
        return "Hello1 GET";
    }


}
