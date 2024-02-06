package org.example.string;

import java.util.Arrays;

public class ChaineCaractere {

    public static void getMethodString() {
        System.out.println("------ Les chaines de caractere ------");

        String s = " hello";

        System.out.println("s.length : " + s.length());
        System.out.println("s.contains(\"he\") : " + s.contains("he"));
        System.out.println("s.isEmpty : " + s.isEmpty());
        System.out.println("S.toUppercase : "+ s.toUpperCase());
        System.out.println("S.startWith : "+ s.startsWith("h"));
        System.out.println("s.endsWith(\" \") : "+ s.endsWith(" "));
        System.out.println("s.replace(\" ll\", \"LL\") : " + s.replace("ll", "LL"));
        System.out.println("s.trim() : " + s.trim());
        System.out.println("s.substring(0,3) : " + s.substring(0,3)); // à partir du 3 c'est retiré
        System.out.println("s.chartArt : " + s.charAt(5) );
        System.out.println("Arrays.toString(s.split(\"e\")) : " + Arrays.toString(s.split("l")));

    }

    public static void getComparaisonString() {
        System.out.println(" --- Comparaison String --- ");

        String s = " hello ";
        String s2 = " hello ";
        System.out.println("s == s2 : " +  (s == s2)); // bien mettre les parenthèses pour faire la comparaison
        System.out.println("s == s2 : " + s.equals(s2));

        String s3 = new String(" hello ");
        System.out.println("s == s3 : " +  (s == s3));

        String firstname = "Fleur";
        String firstname1 = "fleur";
        System.out.println("firstname == firstname1 : " + firstname.equals(firstname1));
        System.out.println("firstname == firstname1 : " + firstname.equalsIgnoreCase(firstname1));

        System.out.println(" ---- Formattage String ----");

        String firstname3 = "Fleur";

        String phrase = "Salut, cher %s !, Good %s ! ";
        String morning = "Morning";
        String evening = "Evening";
        String Afternoon = "Afternoon";

        String nouvellePhrase = String.format(phrase,firstname3,morning);
        System.out.println(nouvellePhrase);
        String phrase1 = "Vous allez gagner %d à l'euromillion";
        int number = 1_000_000;
        String newPhrase = String.format(phrase1,number);
        System.out.println(newPhrase);

        System.out.printf("Vous allez gagner %d à l'euromillion dans %d jours \n",1100000, 10);

        String nomProduit = "Chocolat";
        double prix = 2.99;
        int quantite = 10;

        System.out.printf("Total pour %d unités de %s : %.2f euros" , quantite, nomProduit, prix*quantite);



    }
}
