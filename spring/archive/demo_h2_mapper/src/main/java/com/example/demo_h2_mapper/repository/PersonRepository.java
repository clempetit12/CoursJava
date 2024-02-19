package com.example.demo_h2_mapper.repository;

import com.example.demo_h2_mapper.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Integer> {

    List<Person> findAllByFirstName(String value);
    Long countAllByFirstNameStartingWith(String value);

}
