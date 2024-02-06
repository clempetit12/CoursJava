package org.example;

import com.github.lalyos.jfiglet.FigletFont;
import org.example.models.Maison;
import org.example.models.Person;

//si on lève l'exception elle est envoyé à la console machine virtuelle qui va tout arreter et afficher le probleme : à ne pas faire
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        String asciiArt = FigletFont.convertOneLine("Karaoké");

        System.out.println(asciiArt);

        Person person = new Person();
        person.setId(1);
        System.out.println(person.getId());
        person.setFirstname("Lou");
        person.setLastname("Petit");
        System.out.println(person.getFirstname());
        System.out.println(person);
        Person person1 = new Person(15);

        person1.setFirstname("Lou");
        person1.setLastname("Petit");
        System.out.println(person.equals(person1));

        Maison maison = new Maison(1);


    }
}