package com.example.demo_fragments.controller;

import com.example.demo_fragments.model.Rabbit;
import com.example.demo_fragments.service.RabbitService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/demo")
public class DemoRestController {

private final RabbitService rabbitService;

        @GetMapping
        public List<Rabbit> getRabbits() {
            return rabbitService.getRabbits();
        }

    @GetMapping(value = "/{id}")
    public Rabbit getRabbits(@PathVariable UUID id) {
        return rabbitService.getOneRabbit(id);
    }

    @PostMapping
    public boolean createRabbit(String name, String breed){
            rabbitService.addRabbit(name,breed);
            return true;
    }


}
