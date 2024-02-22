package com.example.demo_aop.controller;

import com.example.demo_aop.service.DemoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("")
public class HomeController {

    private final DemoService demoService;

    public HomeController(DemoService demoService) {
        this.demoService = demoService;
    }


    @GetMapping("/demo")
    public ResponseEntity<String> get() {
////        System.out.println("--- Boolean ----");
////        demoService.methodReturning();
//        System.out.println("---------- Method void avec exception ---------");
//        demoService.method();

        demoService.methodWithAnnotation();

        return ResponseEntity.ok("ok");
    }


}
