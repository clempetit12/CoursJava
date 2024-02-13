package com.example.demo_fragments.controller;

import com.example.demo_fragments.model.Rabbit;
import com.example.demo_fragments.service.RabbitService;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
        Rabbit rabbit = rabbits.get(0);
        Rabbit rabbit2 = rabbits.get(1);
        Rabbit rabbit3 = rabbits.get(2);
        model.addAttribute("idFirstRabbit", rabbit.getId());
        model.addAttribute("idSecondRabbit", rabbit2.getId());
        model.addAttribute("idThirdRabbit", rabbit3.getId());
        return "pageB";
    }

    @GetMapping("/detail/{rabbitId}")
    public String detailRabbit(@PathVariable("rabbitId")UUID id, Model model){
        Rabbit rabbit = rabbitService.getOneRabbit(id);
        model.addAttribute("myRabbit",rabbit);
        return "pagec";
    }
}
