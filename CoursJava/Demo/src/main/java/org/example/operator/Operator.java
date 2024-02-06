package org.example.operator;


import org.example.model.Maison;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Operator {
    //main pour écrire ce qu'il y a en dessous

    public static void getOperator() {

        System.out.println("**** Les opérateurs ****");

        int i = 10;
        int i2 = -10;
        // Incrémentation automatique
        int i3 = ++i;
        //Incrémentation au moment de la réutilisation, après l'affectation
        int i4 = i++;
        int i5 = i;
        int i6 = --i;

    }

public static void getExpression() {
        byte b = 1;
        short s = 1;
        int i = 1;
        long l = 1L;
        float f = 1.0f;
        double d = 1.0;
        char c = 1;

        int express = b+ b;
        int express2 = b + s;

        // underscrore pour grands nombres
        int t = 2_800_741;
    int t2 = 2_800_741;
    int t3 = t + t2;


}
    public static void getOperatorAndComparaison() {
      int int1 = 128;
      int int2 = 128;

        System.out.println("int1 == int2 "+ (int1 == int2));

        //Integer il y a plus de méthodes possibles que avec int
        Integer int3 = 128;
        Integer int4 = 128;

// False car compare l'emplacement mémoire et non la valeur car on déplace la plage -128 127, sur les primitifs la comparaison se fait sans probleme mais en utilisant des wrappers, des objets cela posera probleme
        //car on bascule dans l'emplacement mémoire il faut alors comparer les propriétés
        System.out.println("int3 == int4 "+ (int3 == int4));


        Integer int5 = 127;
        Integer int6 = 127;

// True car compare la valeur car je suis dans l'emplacement mémoire -128 à 127 donc on peut comparer la valeur
        System.out.println("int5 == int6 "+ (int5 == int6));
        Integer int7 = new Integer( 127);
        Integer int8 = new Integer( 128);


// False car compare l'emplacement mémoire et non la valeur car on déplace la plage -128 127, sur les primitifs la comparaison se fait sans probleme mais en utilisant des wrappers, des objets cela posera probleme
        //car on bascule dans l'emplacement mémoire il faut alors comparer les propriétés
        System.out.println("int7 == int8 "+ (int7 == int8));

        Integer int9 = Integer.valueOf(127);
        Integer int10 = Integer.valueOf(127);


//True car on compare la valeur : equals
        System.out.println("int9 == int10 "+ (int9 == int10));
        System.out.println("int3 equals int4 "+ (int3.equals(int4)));

        int[] arr1 = {1,2,3};
        int[] arr2 = {1,2,3};

//False  car on compare l'emplacement mémoire'
        System.out.println("arr1 == arr2 "+ (arr1==arr2));
        System.out.println("arr1 equals arr2 "+ (arr1.equals(arr2)));
        //True car on compare la valeur
        System.out.println("Arrays "+ (Arrays.equals(arr2,arr1)));

        arr1 = arr2;
        // True car meme emplacement mémoire
        System.out.println("arr1 == arr2 "+ (arr1==arr2));

Maison maison = new Maison("maison", 5 );
        Maison maison2 = new Maison("maison", 5 );

        System.out.println("maison == maison2 "+ (maison2 == maison));
        // Même propriétés donc true
        System.out.println("maison == maison2 "+ (maison2.nom == maison.nom));


    }
}


