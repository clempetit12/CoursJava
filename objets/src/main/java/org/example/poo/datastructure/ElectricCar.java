package org.example.poo.datastructure;

public class ElectricCar extends Engine implements Vehicle {

    public ElectricCar() {
        id = Engine.count;
    }

    @Override
    public void drive() {
        System.out.println("Je suis un véhicule électrique qui roule");
    }

    @Override
    public void startEngine() {
        System.out.println("Je suis un véhicule électrique qui démarre");

    }
}
