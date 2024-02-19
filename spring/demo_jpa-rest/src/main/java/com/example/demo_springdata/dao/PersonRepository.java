package com.example.demo_springdata.dao;

import com.example.demo_springdata.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PersonRepository extends JpaRepository<Person,Integer> {


}
