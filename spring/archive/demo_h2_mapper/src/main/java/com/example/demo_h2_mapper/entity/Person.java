package com.example.demo_h2_mapper.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_person", nullable = false)
    private int idPerson;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String email;

    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

}
