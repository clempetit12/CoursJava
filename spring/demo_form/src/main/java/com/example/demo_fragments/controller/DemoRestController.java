package com.example.demo_fragments.controller;

import com.example.demo_fragments.model.Rabbit;
import com.example.demo_fragments.service.RabbitService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/demo")
public class DemoRestController {

private final RabbitService rabbitService;

    @GetMapping
    public List<Rabbit> getRabbits() {
        return rabbitService.getRabbits();
    }

}
