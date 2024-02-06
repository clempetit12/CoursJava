package org.example.models;

import lombok.*;

@Data
@AllArgsConstructor

public class Maison {


    private final int id;
    @NonNull
    private String ville;
    @NonNull
    private int numero;
    @NonNull
    private String adresse;


}
