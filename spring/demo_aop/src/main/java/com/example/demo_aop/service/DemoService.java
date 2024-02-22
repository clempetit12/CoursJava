package com.example.demo_aop.service;

import org.springframework.stereotype.Service;

@Service
public class DemoService {

    public void method() {
     //   System.out.println("Méthode demoService");
        System.out.println("Method demoService");
        throw new RuntimeException();
    }

    public boolean methodReturning() {
        System.out.println("Méthode demoService Return Boolean");
        return true;
    }

public void methodWithAnnotation(){
    System.out.println("Methode with annotTION");
}
}
