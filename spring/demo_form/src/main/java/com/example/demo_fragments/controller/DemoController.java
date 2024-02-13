package com.example.demo_fragments.controller;

import com.example.demo_fragments.model.Rabbit;
import com.example.demo_fragments.service.RabbitService;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class DemoController {


    private final RabbitService rabbitService;

    @GetMapping
    public String homePage() {
        return "pageA";
    }

    @GetMapping(value = "/pageB")
    public String pageB(Model model) {
        List<Rabbit> rabbits = rabbitService.getRabbits();
        model.addAttribute("myRabbits", rabbits);
        return "pageB";
    }

    @GetMapping("/detail/{rabbitId}")
    public String detailRabbit(@PathVariable("rabbitId") UUID id, Model model) {
        Rabbit rabbit = rabbitService.getOneRabbit(id);
        model.addAttribute("myRabbit", rabbit);
        return "pageC";
    }


    @GetMapping("/add")
    public String addRabbit(Model model) {
        model.addAttribute("rabbit", new Rabbit());

        return "form/form";
    }

    @PostMapping("/add")
    public String submitRabbit(@ModelAttribute("rabbit") Rabbit rabbit) {
        Rabbit rabbit1 = Rabbit.builder().id(UUID.randomUUID()).name(rabbit.getName()).breed(rabbit.getBreed()).build();
        rabbitService.addRabbit(rabbit1);
        return "redirect:/";
    }
}
