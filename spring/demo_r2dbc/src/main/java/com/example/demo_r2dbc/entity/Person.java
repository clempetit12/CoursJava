package com.example.demo_r2dbc.entity;

import io.netty.resolver.AddressResolver;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    @Id
    private int id;
    private String firstname;
    private String lastname;


}
