package org.example.function;

import java.util.ArrayList;
import java.util.List;

public class Fonctions {

    public static void getFunction() {
        int result = sum(1, 5, 5);
        System.out.println(result);
        result = sum(7,6);
        System.out.println(result);
        double result1 = sum(45,98,74,189);
        System.out.println(result1);

    }


    public static int sum(int i1, int i2) {
        return i1 + i2;
    }
    // ordre le type et le nom des parametres s'ils sont les meme ce n'est pas possible

    public static int sum(int i1, int i2, int i3) {
        int result = i1 + i2 + i3;
        return result;
    }

    public static double sum(double...doubles) {
        double result = 0;
        for (double d:doubles) {
            result += d;
        }
        return  result;

    }

    public static void tab() {
        int tab [][] = new int [3][3];
        for (int i = 0; i < tab.length; i++) {

            for (int j = 0; j < tab[i].length; j++) {
                System.out.print( " | " );
            }
            System.out.println(  " ]" );
        }
    }


}
