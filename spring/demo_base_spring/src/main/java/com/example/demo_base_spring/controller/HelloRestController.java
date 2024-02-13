package com.example.demo_base_spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// Partie api
// annotation restcontroller spring sait que cest un controller, scanne toutes les méthodes, pas besoin d'instanciation
@RestController
@RequestMapping(value = "/api/v1/home")
public class HelloRestController {
    //Racine de l'application
    @GetMapping
  // @RequestMapping(method = RequestMethod.GET)
    public String sayHello(){
        System.out.println("hello");
        return "Hello World";
    }

    @GetMapping(value = "persons")
    public List<String> sayCoucouJson() {
        return List.of("joelle dupont","eloise tarma","leo piscoli");

    }
}
