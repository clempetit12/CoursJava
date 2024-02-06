package org.example.stream;

public class Main {

    public static void main(String[] args) {
        Calculatrice calculatrice = new Calculatrice();

        //Appeler une méthode qui passe une fonction en paramètre
        double totalAddition = calculatrice.calcul(10,30,(a,b)-> a + b);
        System.out.println(totalAddition);

        //Appeler une méthode qui est dans son contexte pour utiliser avec :: il faut que la methode soit static
        double totalSoustraction = calculatrice.calcul(10,30,Calculatrice::soustraction);
        System.out.println(totalSoustraction);
    }
}
