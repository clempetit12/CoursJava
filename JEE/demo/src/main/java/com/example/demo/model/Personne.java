package com.example.demo.model;

import lombok.Data;

@Data
public class Personne {

    private String firstName;
    private String lastName;

    public Personne(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }


}
