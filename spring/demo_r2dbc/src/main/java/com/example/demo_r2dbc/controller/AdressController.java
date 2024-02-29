package com.example.demo_r2dbc.controller;

import com.example.demo_r2dbc.entity.Address;
import com.example.demo_r2dbc.entity.Person;
import com.example.demo_r2dbc.repository.AdressRepository;
import com.example.demo_r2dbc.repository.PersonRepository;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("adress")
public class AdressController {

    private final AdressRepository adressRepository;

    private final PersonRepository personRepository;


    public AdressController(AdressRepository adressRepository, PersonRepository personRepository) {
        this.adressRepository = adressRepository;
        this.personRepository = personRepository;
    }


    @GetMapping("{id}")

    public Mono<Address> get(@PathVariable("id") long id){
       return adressRepository.findById(id).flatMap(address ->
            personRepository.findById(address.getId())
                    .map(p->{
                        address.setPerson(p);
                        return address;
                    })
        );
    }

    @PostMapping
    public Mono<Address> post(@RequestBody Address address) {
        return adressRepository.save(address);
    }

    @GetMapping("second/{id}")

    public Mono<Address> secondGet(@PathVariable("id") long id) {
        return adressRepository.findAddressByIdWithPerson(id);
    }
}
