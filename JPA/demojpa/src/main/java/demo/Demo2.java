package demo;

import entity.Person;

import javax.persistence.*;
import java.util.List;

public class Demo2 {
    public static void main() {


        EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo_jpa");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();
        try {
            Person person = em.getReference(Person.class, 3L);
            System.out.println(person);

        } catch (EntityNotFoundException ex) {
            System.out.println("Entity non trouvée");
        }

        // Récupération par Query

        // information que l'on cherche c'est le nom dans la classe et non dans la table
        Query query = em.createQuery("select p from Person p where p.nom = 'par' ");
        Person person = (Person) query.getSingleResult();
        System.out.println(person);

        // Récupérer toutes les personnes dont le nom est nam
        List<Person> personList = null;
        personList = em.createQuery("select p from Person p where p.nom = 'nam' ").getResultList();
        for (Person p : personList
        ) {
            System.out.println(p);

        }

        Query query1 = em.createQuery("select p from Person p where p.id > 3 ");
        List<Person> personList2 = null;
        personList2 = query1.getResultList();
        for (Person p : personList2
        ) {
            System.out.println(p);

        }

        // Paramètres nommés
        Query query2 = em.createQuery("select p from Person p where p.id > :id");
        query2.setParameter("id", 3L);
        List<Person> personList3 = null;
        personList3 = query2.getResultList();
        for (Person p : personList3
        ) {
            System.out.println("personne trouvée avec paramètre nommé " + p.getNom());

        }

        System.out.println("Modifier une occurence : ");
        Person person4 = em.find(Person.class, 3L);
        person4.setNom("h");
        person4.setPrenom("irma");


        et.commit();
        person4 = em.find(Person.class, 3L);
        System.out.println("Person :" + person4);


        System.out.println("Rollback : ");


        em.getTransaction().begin();
        Person person6 = new Person("Joe", "Dam");
        person6.setAge(45);
        em.persist(person6);

        if (person6.getId()== 11L) {
            System.out.println("person" + person6.getId());
            et.rollback();
        } else {
            et.commit();
            System.out.println("person" + person6.getId());
        }


        // Ici requete sql mais pas JPQL
        System.out.println("NativeQuery : ");
        List<Person> personList1 = em.createNativeQuery("SELECT * FROM person ", Person.class).getResultList();
        for (Person p: personList1) {
            System.out.println("p : " + p);

        }

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
