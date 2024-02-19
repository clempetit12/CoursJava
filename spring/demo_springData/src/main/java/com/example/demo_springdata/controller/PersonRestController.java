package com.example.demo_springdata.controller;

import com.example.demo_springdata.entity.Person;
import com.example.demo_springdata.service.PersonServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PersonRestController {

    private final PersonServiceImpl personService;

    @GetMapping
    public List<Person> home() {
        return personService.findAll();

    }

    @GetMapping("/add")
    public void addPerson() {
        personService.create(Person.builder()
                .firstName("titi")
                .lastName("titi")
                .email("toto@tata.com")
                .build());

    }

    @ResponseBody
    @GetMapping("/{id}")
    public Person getOnePerson(@PathVariable("id") int id) {
        Person person = personService.findById(id);
        person.getFirstName();
        return person;
    }

    @ResponseBody
    @DeleteMapping("/delete/{id}")
    public boolean deletePerson(@PathVariable("id") int id) {
        return personService.delete(id);
    }

    @GetMapping("/update/{id}")
    public void updatePerson(@PathVariable("id") int id) {
        Person person = Person.builder()
                .firstName("lala")
                .lastName("lala")
                .email("lala@gmail.com")
                .build();
      personService.update(id,person);

    }

}
