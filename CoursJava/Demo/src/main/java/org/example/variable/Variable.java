package org.example.variable;

public class Variable {

    public static void getVariable(){

        byte b = 'A';
        b = 127;
// sout raccourci pour system.out.println()

        System.out.println("valeur de b :" + b);
        short s;
        s = 2000;
        int i = 122;
        //bien mettre le f à la fin du long
        long l = 1524624554L;
        char c = 'm';
        String string = "Hello World";
        boolean bool =true;
        //bien mettre le f à la fin du float
        float f = 1.523f;
        double d = 7.666;
        System.out.println(string);

        i=s;
// Principe de casting on transforme un entier en chaine de caractère
        char c4 = (char) 6900;
        char c5 = 6500;
        System.out.println( "La valeur de C4 : "+ c4);
        System.out.println( "La valeur de C5 : "+ c5);




    }

}
