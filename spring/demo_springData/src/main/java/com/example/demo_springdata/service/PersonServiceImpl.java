package com.example.demo_springdata.service;

import com.example.demo_springdata.dao.PersonRepository;
import com.example.demo_springdata.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Person findById(Integer id) {
       // return personRepository.findByIdPerson(id);
        Optional<Person> result = personRepository.findById(id);
        if(result.isPresent()) {
            return result.get();
        }else {
            throw new RuntimeException("Personne pas trouvée");
        }
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
    public boolean update( Person person) {
            personRepository.save(person);
            return true;
    }
}
