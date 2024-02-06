package org.example.demo_builderlombock;

public class Main {

    public static void main(String[] args) {
        Person person = new Person.PersonBuilder().firstname("olivia").lastname("Pigani").build();
        System.out.println(person);

        // Utilisation de la réflexion
//        Class<?> classPerson = Class.forName("org.example.demo_builderlombock.Person");

    }


}
