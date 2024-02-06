package org.example;

import org.example.generique.Boite;

public class Main {
    public static void main(String[] args) {
        Boite<String> boite = new Boite("toto");

        System.out.println(boite.getContenu());

        Boite<Integer> boite2 = new Boite<Integer>(1);


    }
}