package org.example.models;

import lombok.*;

@Getter
@Setter
@ToString
//Constructeur avec un paramètre ou plusieurs mais il faut @Null audessus du paramètre souhaité
@RequiredArgsConstructor
//ajout constructor vide
@NoArgsConstructor
//Constructor avec tous les paramètres
@AllArgsConstructor
// ne compare pas les adresses mémoires mais les valeurs que l'on souhaite comparer
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Person {

// les getter et setter sont appliqués que sur l'élément qui se trouve en dessous

    @NonNull
    private int id;

    @EqualsAndHashCode.Include // élément dont on souhaite comparer la valeur
    private String firstname;

    @EqualsAndHashCode.Include // élément dont on souhaite comparer la valeur
    private String lastname;



}
