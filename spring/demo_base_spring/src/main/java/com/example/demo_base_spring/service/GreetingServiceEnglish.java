package com.example.demo_base_spring.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service(value = "greetings")
//@Primary
public class GreetingServiceEnglish implements GreetingService {    @Override
public String sayHello() {
    return "Hello Everyone";
}
}
