package org.example.poo.datastructure;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        ElectricCar electricCar = new ElectricCar();
        electricCar.setCouleur("rouge");
        electricCar.setNombreDeRoues(5);
        Motorcycle motorcycle = new Motorcycle();
        motorcycle.setCouleur("orange");
        motorcycle.setNombreDeRoues(2);
        PetroleCar petroleCar = new PetroleCar();
        petroleCar.setCouleur("bleu");
        petroleCar.setNombreDeRoues(4);
        SuperCar superCar = new SuperCar();

        Engine[] engines = {electricCar, motorcycle, petroleCar};
        Vehicle[] vehicles = {superCar, electricCar, petroleCar, motorcycle};

        System.out.println(Arrays.toString(engines));


        for (Engine engine: vehicles) {
            moveVehicule(engine);
        }

    }

    public static void moveVehicule(Engine engine) {
        if (engine instanceof ElectricCar) {
            System.out.println("electric car");
            ((ElectricCar) engine).drive();
        } else if (engine instanceof Motorcycle) {
            System.out.println("motorcycle");
            //downcast
            ((Motorcycle) engine).drive();
        } else  {
            System.out.println("petrolcar");
            ((PetroleCar) engine).drive();
        }
    }

}
