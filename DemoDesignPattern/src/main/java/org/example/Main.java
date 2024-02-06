package org.example;

import org.example.demo_builder.Voiture;

public class Main {
    public static void main(String[] args) {
        Voiture voiture = new Voiture.Builder().marque("renault").model("3").build();
        voiture = new Voiture.Builder().marque("m1").build();
        voiture.setPrix(7000);
        Voiture voiture1 = new Voiture.Builder().marque("m2").model("renault").prix(10000).annee(2020).build();
        System.out.println(voiture1);

        System.out.println(voiture);

    }
}