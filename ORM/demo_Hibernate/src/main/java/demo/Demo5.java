package demo;

import demo.composeKey.Employee;
import demo.embbeded.Agence;
import demo.embbeded.AgenceId;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Demo5 {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        AgenceId agenceId = new AgenceId(12345,"Lille-Agence");

        Agence agence = new Agence(agenceId,"15 rue de la paix");
        session.save(agence);
        session.getTransaction().commit();

        session.close();
        sessionFactory.close();
    }
}
