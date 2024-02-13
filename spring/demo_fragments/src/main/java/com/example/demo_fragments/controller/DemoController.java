package com.example.demo_fragments.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    @GetMapping
    public String homePage() {
        return "pageA";
    }
    @GetMapping(value = "/pageB")
    public String pageB() {
        return "pageB";
    }
}
