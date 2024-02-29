package com.example.demo_r2dbc.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

@Data
public class Address {


    @Id
    private Long id;

    private String fullAddress;

    private Long personId;

    @Transient
    private Person person;
}
