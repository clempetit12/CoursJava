package demo;

import demo.model.Personne;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import org.hibernate.type.StringType;

import java.util.ArrayList;
import java.util.List;

public class Demo3 {

    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        // Recherche de personnes commençant par M
        String search = "M";
        Query<Personne> personneQuery = session.createQuery("from Personne where firstName like :prenom");
        personneQuery.setParameter("prenom", search + "%", StringType.INSTANCE);
        List<Personne> personneListStartWithM = personneQuery.list();
        for (Personne p : personneListStartWithM
        ) {
            System.out.println("Personnes commençant avec M " + p.getFirstName());

        }

        Query<Personne> personneQuery2 = session.createQuery("from Personne where firstName like ?1");
        personneQuery2.setParameter(1, search + "%");
        List<Personne> personneListposition = personneQuery.list();
        for (Personne p : personneListposition
        ) {
            System.out.println("Personnes en premiere position " + p.getFirstName());

        }

        // Fonction d'aggrégation
//Max
        Query<Integer> query = session.createQuery("select max(age) from Personne ");
        int maxAge = query.uniqueResult();
        System.out.println(maxAge);

// Avg()
        double query2 = (double) session.createQuery("select avg (age) from Personne ").uniqueResult();
        System.out.println("Moyenne age " + query2);

        // Utilisation IN

        List noms = new ArrayList<String>();

        noms.add("petit");
        noms.add("Théa");
        Query<Personne> query1 = session.createQuery(" from Personne where lastName in :noms ");
        query1.setParameter("noms", noms );
        List<Personne> personneList = query1.list();
        for (Personne p: personneList
             ) {
            System.out.println("Personne : " + p.getLastName());
        }

        // Utilisation execute update

        String update_query = "update Personne set lastName= :lastNameP where id=2";
        Query query3 = session.createQuery(update_query);
        query3.setParameter("lastNameP","Parmi");
        int success = query3.executeUpdate();


    }
}
