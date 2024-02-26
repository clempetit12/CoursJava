package com.example._spring_reactive.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.awt.*;
import java.time.Duration;

@RestController
@RequestMapping("reactives")
public class DemoReactiveController {

    @GetMapping
    public Mono<String> get(){
        return Mono.just("Hello from get method");
    }

    @GetMapping(value = "flux", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> getFlux() {
        return Flux.just("toto", "tata", "titi").delayElements(Duration.ofSeconds(2));
    }

}
