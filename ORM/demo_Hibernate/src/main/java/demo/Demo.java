package demo;

import demo.model.Personne;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Demo {
    public static void main(String[] args) {

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

        Session session = sessionFactory.openSession();
        session.getTransaction().begin();

        // Crééer une personne

        Personne personne = new Personne();
       personne.setFirstName("Leo");
       personne.setLastName("petit");
      personne.setAge(20);
      session.save(personne);
       System.out.println("Personne : " + personne.getIdPerson());

        // Récupérer une personne  :

//        Personne personne = session.load(Personne.class, 1L);
//        System.out.println("Personne : " + personne.getFirstName());

        // Modification personne :

//        personne.setFirstName("théo");
//        session.update(personne);


        System.out.println("Le nouveau prénom est " + personne.getFirstName());

        // Delete personne

     //   session.delete(personne);

        session.getTransaction().commit();

        session.close();
        sessionFactory.close();


    }
}
