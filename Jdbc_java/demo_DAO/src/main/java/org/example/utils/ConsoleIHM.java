package org.example.utils;

import org.example.models.Person;
import org.example.service.PersonService;

import java.util.Scanner;

public class ConsoleIHM {

    private Scanner scanner;
    private PersonService personService = new PersonService();

    public ConsoleIHM() {
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        int choix;
        do {
            printMenu();
            choix = scanner.nextInt();
            scanner.nextLine();
            switch (choix) {
                case 1:
                    createPersonIhm();
                    break;
                case 2:
                    updatePersonIhm();
                    break;
                case 3:
                    getpersonIhm();
                    break;
                case 4:
                    deletePersonihm();
                    break;
                case 5:
                    getAllPersonsIhm();
                    break;
                case 6:
                    scanner.close();
                    break;

            }
            personService.close();
        }
        while (choix != 0);
    }

    private void getAllPersonsIhm() {
        personService.getAllPersons().forEach(e -> System.out.println(e));
    }

    private void deletePersonihm() {
        System.out.println("Merci de saisir l'id de la personne  : ");
        int id = scanner.nextInt();
        scanner.nextLine();
        personService.deletePerson(id);
        if (personService.deletePerson(id)) {
            System.out.println("Une personne a été supprimée avec succès !");
        } else {
            System.out.println("La suppression n'a pas pu se faire");
        }
        ;

    }

    private void getpersonIhm() {
        System.out.println("Merci de saisir l'id de la personne  : ");
        int id = scanner.nextInt();
        scanner.nextLine();
        personService.getPerson(id);
        Person searchedPerson = personService.getPerson(id);
        System.out.println(searchedPerson);
    }

    private void updatePersonIhm() {
        System.out.println("Merci de saisir l'id de la personne à modifier");
        int id = scanner.nextInt();
        scanner.nextLine();
        Person person = personService.getPerson(id);
        if (person != null) {
            System.out.println("Merci de saisir un prénom");
            String firstname = scanner.nextLine();
            System.out.println("Merci de saisir un nom");
            String lastName = scanner.nextLine();
            Person newperson = new Person(person.getId(), firstname, lastName);
            personService.updatePerson(newperson);
            Person personUpdated = personService.getPerson(id);
            System.out.println(personUpdated);
        } else {
            System.out.println("Il n'y a pas de personne qui correspond à cet id");
        }
    }

    private void createPersonIhm() {
        System.out.println("Merci de saisir un prénom");
        String firstname = scanner.nextLine();
        System.out.println("Merci de saisir un nom");
        String lastName = scanner.nextLine();
        if (personService.createPerson(firstname, lastName)) {
            System.out.println("Une personne a été créée avec succès !");
        } else {
            System.out.println("la création n'a pas pu se faire");
        }
        ;

    }

    private void printMenu() {
        System.out.println("=== Menu ===");
        System.out.println("1. Créer une personne");
        System.out.println("2. Modifier une personne");
        System.out.println("3. Récupérer une personne par son id");
        System.out.println("4. Supprimer une personne");
        System.out.println("5. Afficher toutes les personnes");
        System.out.println("6. Quitter");
        System.out.println("Saisissez votre choix :");
    }


}
