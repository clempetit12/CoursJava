package com.example.demo_springdata.service;

import com.example.demo_springdata.dao.PersonRepository;
import com.example.demo_springdata.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService{
    private PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @Override
    public Person findById(int id) {
        return personRepository.getById(id);
    }

    @Override
    public Person create(Person person) {
        return personRepository.save(person);
    }

    @Override
    public boolean delete(int id) {
        Person person = findById(id);
        personRepository.delete(person);
        return true;
    }

    @Override
    public Person update(int id, Person person) {
        Person personToUpdate = findById(id);
        personToUpdate.setFirstName(person.getFirstName());
        personToUpdate.setLastName(person.getLastName());
        personToUpdate.setEmail(person.getEmail());
        personRepository.save(personToUpdate);
        return personToUpdate;
    }
}
