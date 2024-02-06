package org.example.poo.datastructure;

public class Motorcycle extends Engine implements Vehicle {
    public Motorcycle() {
        id=Engine.count;
    }

    @Override
    public void drive() {
        System.out.println("Je suis un motorcycle qui roule");
    }

    @Override
    public void startEngine() {

        System.out.println("Je suis un motorcycle qui demarre");

    }
}
