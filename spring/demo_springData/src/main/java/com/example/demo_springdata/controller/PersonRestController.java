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

    @PostMapping("/add")
    public void addPerson(@RequestBody Person person) {
        personService.create(person);

    }


    @GetMapping("/{id}")
    public Person getOnePerson(@PathVariable("id") int id) {
        return personService.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deletePerson(@PathVariable("id") int id) {
        return personService.delete(id);
    }

    @PutMapping("/update/{id}")
    public void updatePerson(@PathVariable("id") int id, @RequestBody Person person) {
     if(person.getIdPerson() == id){
         personService.update(person);
     }


    }

}
