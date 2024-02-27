package com.example.demor2dbc.dao;

import com.example.demor2dbc.entity.Person;
import io.r2dbc.spi.ConnectionFactory;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class PersonDao {

    private final ConnectionFactory connectionFactory;

    //permet d'interagir avec la base de donnée de manière réactive
    private DatabaseClient databaseClient;

    public PersonDao(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
        databaseClient = DatabaseClient.create(connectionFactory);
        databaseClient.sql("CREATE TABLE IF NOT EXISTS person(id int primary key auto_increment, firsstname varchar(100), lastname varchar(100))")
                .then().doOnSuccess((Void) -> {
                    System.out.println("Création de la table OK");
                });
    }


        public Flux<Person> getAll() {
            return databaseClient.sql("SELECT * from person").fetch()
                    .all()
                    .map(m -> Person.builder().id(Integer.valueOf(m.get("id").toString()))
                            .firstname(m.get("firstname").toString())
                            .lastname(m.get("lastname").toString())
                            .build());
        }

        public void add(String firstname, String lastname){
        Mono result =  databaseClient.sql("INSERT INTO person (firstname,lastname) values(:firstname, :lastname)")
                .bindProperties(Person.builder().firstname(firstname).lastname(lastname).build()).fetch().one();
    }


}
