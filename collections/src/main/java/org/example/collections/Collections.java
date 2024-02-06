package org.example.collections;

import java.util.*;

public class Collections {
    public static void main(String[] args) {
        //Vector
        Vector<String> vector = new Vector<>();
        vector.add("apple");
        vector.add("banane");
        vector.add("orange");
        System.out.println("Vector " + vector);

        //Methodes pour le vector
        System.out.println("Taille du vector" + vector.size());
        System.out.println("Element à l'index 1 " + vector.elementAt(1));
        System.out.println("Est ce que apple est présent " + vector.contains("apple"));


        // Démo SortedSet (Treeset) n'accepte pas les doublons
        SortedSet<String> sortedSet = new TreeSet<>();
        sortedSet.add("Java");
        sortedSet.add("Python");
        sortedSet.add("Python");
        // s'il y a un doublon il n'affiche pas le doublon
        System.out.println("SortedSet" + sortedSet);

        sortedSet.add("C++");
        // trier automatiquement par chaine de caractère
        System.out.println("SortedSet" + sortedSet);

        //Méthodes pour sortedSet
        System.out.println("1 - Premier élément " + sortedSet.first());
        System.out.println("1 - Dernier élément " + sortedSet.last());
        SortedSet<String> headset = sortedSet.headSet("Python");
        System.out.println("1 - Sous ensemble avant Python " + headset);
        SortedSet<String> subset = sortedSet.subSet("C++", "Java");
        System.out.println("1 - Sous ensemble avant Python " + subset);

        //Démo pour LinkedList
        LinkedList<Double> linkedList = new LinkedList<>();
        linkedList.add(5.89);
        linkedList.add(3.14);
        linkedList.add(7.69);
        System.out.println("LinkedList " + linkedList);

        //Méthodes pour le linkedList
        System.out.println("1 - Premier élément " + linkedList.getFirst());
        System.out.println("1 - Dernier élément " + linkedList.getLast());
        linkedList.removeFirst();
        System.out.println("1 - Premier élément enlevé " + linkedList);
        linkedList.removeLast();
        System.out.println("1 - Dernier élément supprimé " + linkedList);

        //SortedMap (TreeMap) sortedmap est une interface
        SortedMap<String, Integer> sortedMap = new TreeMap<>();
        sortedMap.put("Java", 500);
        sortedMap.put("Python", 200);
        sortedMap.put("C++", 800);
        //tableau affiché par les clés qui sont triées
        System.out.println("SortedMap " + sortedMap);

        //Méthodes pour sortedMap
        System.out.println("1 - Clés de sortedMap  " + sortedMap.keySet());
        System.out.println("2 - Values de sortedMap  " + sortedMap.values());
        System.out.println("3 - Supprimer l'entrée avec la clé 'Java   " );
        sortedMap.remove("Java");
        System.out.println(sortedMap);

        //Pour parcourir le tableau d'après les clés pour récupérer les valeurs
        for (String k: sortedMap.keySet()) {
            System.out.println( "Les valeurs pour la clé " + k + " est de valeur " + sortedMap.get(k));
        }


        //HashMap
        HashMap<String,Integer> hashMap = new HashMap<>();
        hashMap.put("Orange", 5);
        hashMap.put("Pomme", 10);
        hashMap.put("Poire", 40);
        System.out.println("Hashmap " + hashMap);

        // Méthode pour HashMap

        System.out.println("Taille du hashmap " + hashMap.size());
        System.out.println("Valeur associée à la clé Pomme " + hashMap.get("Pomme"));
        System.out.println("La clé Javascript est elle présente ?  " + hashMap.containsKey("Javascript"));
        hashMap.remove("Poire");
        System.out.println(hashMap);



    }
}
