package com.example.demo_base_spring.controller;

import com.example.demo_base_spring.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloControllerSet {

    // Injection de dépendances

    private final GreetingService greetingService;
//    private final GreetingService greetingService2;


    //Autowired n'est pas obligatoire quand il y a un seul constructeur
    //@Autowired
    public HelloControllerSet(@Qualifier("accueil") GreetingService greetingService) {
        this.greetingService = greetingService;
     //   this.greetingService2 = greetingService2;
       }

    @RequestMapping(value = "/hello-set")
    public String sayHello() {
        System.out.println(greetingService.sayHello());
     //   System.out.println(greetingService2.sayHello());
        return "home";
    }
}
