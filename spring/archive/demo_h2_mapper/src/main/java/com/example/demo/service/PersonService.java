package com.example.demo.service;


import com.example.demo.entities.Person;
import com.example.demo.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private final PersonRepository personRepository;


    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> listPersons(){
        return personRepository.findAll();
    }


    public Person addPerson(Person person){
        return personRepository.save(person);
    }
}
