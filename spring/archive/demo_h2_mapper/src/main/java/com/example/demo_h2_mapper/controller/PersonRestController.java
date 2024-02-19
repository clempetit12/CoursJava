package com.example.demo_h2_mapper.controller;

import com.example.demo_h2_mapper.entity.Person;
import com.example.demo_h2_mapper.service.PersonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonRestController {

    private final PersonService personService;


    public PersonRestController(PersonService personService) {
        this.personService = personService;
    }


    @GetMapping("/list")
    public List<Person> getAllPersons() {
        return personService.getPersons();
    }

    @GetMapping("/add")
    public Person addPerson(@RequestBody Person person) {
        return personService.addPerson(person);
    }

}
