package com.example.demo_springdata.service;

import com.example.demo_springdata.entity.Person;

import java.util.List;

public interface PersonService {

    List<Person> findAll();
    Person findById(int id);
    Person create(Person person);
    boolean delete(int id);

    Person update(int id, Person person);
}
