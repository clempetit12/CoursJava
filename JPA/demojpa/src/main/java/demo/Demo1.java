package demo;

import entity.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Demo1 {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo_jpa");

    public static void main() {

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Person person = new Person("théa", "nam");
        em.persist(person);
        System.out.println("person " + person.getId());
        em.getTransaction().commit();
        em.close();
        emf.close();


    }

    public static void find() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Person person = em.find(Person.class, 1L);
        System.out.println(person);
        em.close();
        emf.close();

    }

    public static void remove() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Person person = em.find(Person.class, 4L);
        em.remove(person);
        // besoin d'utiliser le commit pour supprimer
        em.getTransaction().commit();
        System.out.println(person);
        em.close();
        emf.close();

    }

    public static void createQuery() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Person person = new Person("théa", "nam");
        Person person1 = new Person("théa", "par");
        em.persist(person);
        em.persist(person1);

        List<Person> personList = null;
        personList = em.createQuery("select p from Person p ", Person.class).getResultList();

        for (Person p : personList) {
            System.out.println(p);
        }
        // si on ne commit les personnes ne sont pas enregistrées dans la bdd meme si ca saffiche en console
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
