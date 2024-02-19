package com.example.demo_h2_mapper.service;

import com.example.demo_h2_mapper.entity.Person;
import com.example.demo_h2_mapper.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private final PersonRepository personRepository;


    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getPersons() {
        return personRepository.findAll();
    }

    public Person addPerson(Person person) {
       return personRepository.save(person);
    }
}
