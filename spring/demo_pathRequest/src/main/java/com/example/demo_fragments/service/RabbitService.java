package com.example.demo_fragments.service;

import com.example.demo_fragments.model.Rabbit;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class RabbitService {

    private final Map<UUID, Rabbit> rabbits;


    public RabbitService() {
        rabbits = new HashMap<>();

        Rabbit rabbit = Rabbit.builder().breed("angora")
                .name("fleur").id(UUID.randomUUID()).build();
        Rabbit rabbit2 = Rabbit.builder().breed("nain")
                .name("titi").id(UUID.randomUUID()).build();
        Rabbit rabbit3 = Rabbit.builder().breed("bélier")
                .name("chocolat").id(UUID.randomUUID()).build();

        rabbits.put(rabbit.getId(), rabbit);
        rabbits.put(rabbit2.getId(), rabbit2);
        rabbits.put(rabbit3.getId(), rabbit3);


    }


    public List<Rabbit> getRabbits() {
        return rabbits.values().stream().toList();
    }

    public Rabbit getOneRabbit(UUID id) {
        return rabbits.values().stream().filter(rabbit -> rabbit.getId().equals(id)).findFirst().orElse(null);
        //ou rabbits.get(id);
    }


}
