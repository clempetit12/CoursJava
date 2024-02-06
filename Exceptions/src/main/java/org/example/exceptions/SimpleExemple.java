package org.example.exceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SimpleExemple {

    public static void main(String[] args) {

        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("----- Division -----");
            System.out.println("Donnez moi un nombre : ");
            Integer valeur = scanner.nextInt();
            System.out.println("Donnez moi un 2e nombre : ");
            Integer valeur2 = scanner.nextInt();
            float resultat = valeur / valeur2;
            System.out.println("résultat = " + resultat);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Problème de saisie");
        } catch (Exception e) {
            System.out.println("Une exception est apparue !");
        }
        System.out.println("Fin du programme !");
    }
}
