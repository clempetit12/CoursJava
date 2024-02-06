package org.example.collections;

import java.util.ArrayList;

public class List {

    public static void main(String[] args) {

        //ArrayList<type> <nom> = new ArrayList<type>()

        ArrayList<String> prenoms = new ArrayList<String>();

        //La méthode pour ajouter des éléments add

        prenoms.add("toto");
        prenoms.add("tata");
        prenoms.add("clara");

        // pour récupérer get

        System.out.println(prenoms.get(0));
        System.out.println(prenoms.get(1));
        System.out.println(prenoms.get(2));

        //La méthode pour modifier set

        prenoms.set(1,"taram");
        System.out.println(prenoms.get(1));

        // La méthode pour retirer quelque chose remove et connaitre taille de la liste size
        System.out.println(prenoms.size());
        prenoms.remove(2);
        System.out.println(prenoms.size());

        //La méthode pour parcourir le tableau et afficher les éléments

        for (int cpt=0; cpt < prenoms.size(); cpt++){
            System.out.println(prenoms.get(cpt));
        }


        //Beaucoup plus utilisée la forech

        for (String element: prenoms) {
            System.out.println(element);
        }





    }
}
