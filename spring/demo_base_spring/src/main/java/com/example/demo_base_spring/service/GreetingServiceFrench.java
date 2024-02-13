package com.example.demo_base_spring.service;

import org.springframework.stereotype.Service;

@Service(value = "accueil")
public class GreetingServiceFrench implements GreetingService {
    @Override
    public String sayHello() {
        return "Bonjour tout le monde";
    }
}
