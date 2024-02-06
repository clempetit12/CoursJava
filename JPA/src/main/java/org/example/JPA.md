# JPA (Java Persistance Api) 02/01/2024

Outil bas niveau (JDBC)
Bas niveau : Au niveau bas niveau, vous devez gérer manuellement la connexion à la base de données en établissant une connexion, en créant des déclarations SQL et en gérant les exceptions associées.

Niveau Haut (High-Level) (ORM)

    Utilisation de frameworks ou ORM : Au niveau haut niveau, vous pouvez utiliser des frameworks ou des outils tels que Spring JDBC ou Hibernate. Ces outils simplifient le processus en fournissant des abstractions supplémentaires.
    Abstraction de la gestion de la connexion : Les outils de haut niveau gèrent souvent automatiquement la connexion à la base de données, réduisant ainsi la complexité.
    Mapping objet-relationnel : Certains outils permettent le mapping objet-relationnel, facilitant le passage entre les objets Java et les tables de la base de données sans nécessiter une manipulation directe de SQL.


ORM : faciliter l'écriture de la couche DAO 

## ORM
ORM (Object Rrlation Mapping) :permettent de mettre en relation notre entité (model) avec une table de la bdd.
(fournit des méthodes pour faire les requêtes) facilite la persistance (enregistrer les données de manière durable) des applications.


- Entity (class) ==> une table, chaque attribut une colonne
- Instance ==> une ligne de la table 

Sun microsystème (ils ont fondé Java, openffice)

JPA : spécification, que des standards, des interfaces pour intéragir avec la bdd.
Tous les ORM vont se baser sur les contraintes JPA.
JPA ne peut pas etre utilisé seul. 

Boiler plate : code qui n'a pas de plus value


## JPA

- Java SE : standard edition (desktop)
- Java EE : entreprise edition (web)

JPQL référence à la classe et non la table 



## Les Entités

POJO : Plain Old Java Object (classe la plus basique possible en java)
Classe final :
En Java, la classe final est un modificateur qui peut être appliqué à une classe pour indiquer qu'elle ne peut pas être étendue, c'est-à-dire qu'aucune autre classe ne peut hériter de cette classe

Exemple Variable final :

public class MaClasse {
public final int MA_CONSTANTE = 42;
}

Méthode final :

public class MaClasse {
public final void maMethode() {
// Corps de la méthode
}
}

Dans cet exemple, la méthode maMethode est déclarée comme final. Cela signifie qu'aucune sous-classe ne peut redéfinir cette méthode. L'intention derrière l'utilisation de la méthode final est souvent d'éviter que des modifications soient apportées à la logique de la méthode dans les classes dérivées.
Dans cet exemple, MA_CONSTANTE est déclarée comme final, ce qui signifie qu'une fois qu'elle est initialisée, sa valeur ne peut plus être modifiée. C'est souvent utilisé pour définir des constantes.


## Contexte de persistance 

On peut y mettre des entités ou les enlever.
On peut choisir ce qui va persister ou non. Sorte de conteneur où on garde l'information jusqu'à qu'on commit lors de la transaction.
 => Pour faire ça besoin d'un Entity Manager(gère cycle de vie d'une entity) 
 
## Annotations

  @Table (name = nom de la table si différent de la classe entity)
  Dès qu'on met annotation Entity il faut mettre @id pour avoir un identifiatn unique
  Pour la generation id différentes stratégies :
- automatique (bdd)
- identity (generatedValue)
- sequence

- @Column obligatoire quand les noms de la table sont différents

Hibernate va générer les entités à partir des tables (reverse engineering)

- serializable : interface qui permet de stocker des objets java

1. EntityManagerFactory => EntityManager (classe annotée avec entity sont gérées par EntityManager)
2. Fichier de configuratin : definition de chacune des entity + informations sur où se trouvent les données

Lorsque vous parlez de "beans entité", vous faites probablement référence à des classes Java qui sont à la fois des beans (simples classes Java avec des propriétés et des méthodes) et des entités persistantes (capables d'être stockées dans une base de données). Ceci est couramment utilisé dans les frameworks de persistance comme Hibernate.

## Méthodes entityManager
- void persist(Object entité) => entité qui sera gérée par entityManager bascule dans le contexte de persistance
- void remove(Object entité) => suppresion données dans la bdd
- void flush() => envoie les modifications en bdd sans attendre le commit 
- void lock() => bloquer utilisation de l'entité tant que la transaction n'est pas terminée

