package com.example.demo_base_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class HelloController {

    @RequestMapping(value = "/")
    public String sayHello() {
        System.out.println("coucou !");
        return "hello";
    }

    @RequestMapping(value = "/coucou")
    @ResponseBody
    public List<String> getPersons(){
        return List.of("joelle dupont","eloise tarma","leo piscoli");
    }

@RequestMapping(value = "/toto")
    public String showToto() {
        return "toto";
}

@RequestMapping("/home/person")
public String personName(Model model){
        model.addAttribute("firstName","Olivia");
        model.addAttribute("lastName","Pigani");

        List<String> persons = List.of("joelle dupont","eloise tarma","leo piscoli");
        model.addAttribute("persons", persons);


        return "person/details";

}

}
