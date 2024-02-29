package com.example.demo_r2dbc.repository;

import com.example.demo_r2dbc.entity.Address;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Mono;

public interface AdressRepository  extends R2dbcRepository<Address,Long> {

    @Query("Select a.id, a.fullAdress, p.id, p.firstname, p.lastname from person p inner join address a on a.person_Id = p.id where a.id=:id ")
    Mono<Address> findAddressByIdWithPerson(long id);
}
