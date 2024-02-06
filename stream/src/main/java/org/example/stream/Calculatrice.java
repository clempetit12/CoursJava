package org.example.stream;

public class Calculatrice {

    public double addition (double a, double b) {
        return a+b;
    }

    public static double soustraction (double a, double b) {
        return a-b;
    }

    public double multiplication (double a, double b) {
        return a*b;
    }

    public double calcul(double a, double b, MethodCalcul  methode) {
        return methode.run(a, b);
    }
}
