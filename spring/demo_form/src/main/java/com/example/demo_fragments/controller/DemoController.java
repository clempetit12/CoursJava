package com.example.demo_fragments.controller;

import com.example.demo_fragments.model.Rabbit;
import com.example.demo_fragments.service.RabbitService;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        String name = rabbit.getName();
        String breed = rabbit.getBreed();
        if (rabbitService.addRabbit(name, breed)) {
            System.out.println("Un lapin a bien été ajouté ");
        }

        return "redirect:/pageB";
    }

    @GetMapping("/addRabbit")
    public String submitRabbitViaGet(@RequestParam("name") String name,
                                     @RequestParam("breed") String breed) {
        if (rabbitService.addRabbit(name, breed)) {
            System.out.println("Un lapin a bien été ajouté ");
        }

        return "redirect:/pageB";
    }


    @GetMapping("/look")
    public String showRabbit(@RequestParam(name = "nameRabbit", required = false) String name, Model model) {
        Rabbit rabbit = rabbitService.getRabbitByName(name);
        System.out.println(rabbit);
        if (rabbit != null) {
            model.addAttribute("myRabbit", rabbit);
            return "pageC";
        } else {
            return "pageD";
        }

    }
}
