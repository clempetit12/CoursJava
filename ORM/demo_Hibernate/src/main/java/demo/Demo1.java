package demo;

import demo.model.Personne;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.util.Iterator;
import java.util.List;

public class Demo1 {


    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        // HQL

     Query<Personne> personneQuery = session.createQuery("from Personne ");
        List<Personne> personneList = personneQuery.list();

        for (Personne p: personneList) {
            System.out.println(p);
        }

        Iterator<Personne> personneIterator = personneQuery.iterate();

        while (personneIterator.hasNext()){
            Personne personne = personneIterator.next();
            System.out.println("Personne avec iterator " + personne);


        }

        // Une requete avec filtre pour récupérer une liste :

        Query<Personne> personneQuery1 = session.createQuery("from Personne where firstName='Petit'");
        List<Personne> personneList1 = personneQuery1.list();
        for (Personne p: personneList1
             ) {
            System.out.println("Personne avec un nom en paramètre : " + p);
        }

        Query<Personne> personneQuery3 = session.createQuery("from Personne where id=2");
        List<Personne> personneList3 = personneQuery3.list();
        for (Personne p: personneList1
        ) {
            System.out.println("Personne avec un id en paramètre : " + p);
        }

    }
}
