package com.example.demo.service;


import com.example.demo.entities.Person;
import com.example.demo.mapper.PersonMapper;
import com.example.demo.model.PersonDto;
import com.example.demo.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    public PersonService(PersonRepository personRepository, PersonMapper personMapper) {
        this.personRepository = personRepository;
        this.personMapper = personMapper;
    }

    public List<PersonDto> listPersons() {
        return personRepository.findAll().stream().map(personMapper::personToPersonDto).toList();
    }


    public PersonDto addPerson(PersonDto personDto) {
        return personMapper.personToPersonDto(personRepository.save(personMapper.personDtoToPerson(personDto)));
    }
}
