package com.example.demo_springdata.service;

import com.example.demo_springdata.entity.Person;

import java.util.List;

public interface PersonService {

    List<Person> findAll();
    Person findById(Integer id);
    Person create(Person person);
    boolean delete(int id);

    boolean update(Person person);
}
