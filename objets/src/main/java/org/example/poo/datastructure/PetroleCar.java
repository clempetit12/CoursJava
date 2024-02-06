package org.example.poo.datastructure;

public class PetroleCar extends Engine implements Vehicle {


    public PetroleCar() {
        id = Engine.count;
    }

    @Override
    public void drive() {
        System.out.println("Je suis un petrolcar qui roule");

    }

    @Override
    public void startEngine() {
        System.out.println("Je suis un petrolcar qui demarre");
    }
}
