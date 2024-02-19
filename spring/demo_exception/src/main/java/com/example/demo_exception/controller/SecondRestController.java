package com.example.demo_exception.controller;

import com.example.demo_exception.exception.CustomException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecondRestController {

    @GetMapping("/bye")
    public String hello() {
        Integer error = 25/0;
        return "bye world";
    }

    @GetMapping("/byebye")
    public String bye() {
        if (true){
            throw new CustomException("Oups !!!");
        }
        return "Bye bye World";

    }
}
