package com.example.demo.repository;

import com.example.demo.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person,Integer> {
    List<Person> findAllByFirstNameStartingWith(String value);
    Long countAllByFirstNameStartingWith(String value);
}
