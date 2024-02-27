package com.example.demor2dbc.controller;


import com.example.demor2dbc.dao.PersonDao;
import com.example.demor2dbc.entity.Person;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("person")
public class PersonController {


    private final PersonDao personDao;

    public PersonController(PersonDao personDao) {
        this.personDao = personDao;
    }

    @PostMapping
    public void  post(@RequestBody Person person){
        personDao.add(person.getFirstname(),person.getLastname());
    }

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Person> get(){
        return personDao.getAll();
    }





}