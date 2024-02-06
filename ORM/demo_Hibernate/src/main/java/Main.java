import heritage.joined.CreditCardPayment;
import heritage.joined.PayPalPayment;
import heritage.single_table.CreditCardPayment1;
import heritage.single_table.PayPalPayment1;
import heritage.table_per_class.CreditCardPayment2;
import heritage.table_per_class.PayPalPayment2;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.Service;
import org.hibernate.service.ServiceRegistry;

import java.util.Date;

public class Main {
    public static void main(String[] args) {

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            // Exemple joined table :

//            CreditCardPayment creditCardPayment = new CreditCardPayment();
//            creditCardPayment.setCardNumber("123456");
//            creditCardPayment.setAmount(5000.0);
//            creditCardPayment.setPaymentDate(new Date());
//            creditCardPayment.setExpirationDate("12/2025");
//
//
//            PayPalPayment payPalPayment = new PayPalPayment();
//            payPalPayment.setAccountNumber("45879");
//            payPalPayment.setPaymentDate(new Date());
//            payPalPayment.setAmount(9854.5);


//            session.save(creditCardPayment);
//            session.save(payPalPayment);
//
//
//            System.out.println("creditCardPayment " + creditCardPayment);
//            System.out.println("payPalPayment " + payPalPayment);

            // Demo single table
//            CreditCardPayment1 creditCardPayment1 = new CreditCardPayment1();
//            creditCardPayment1.setCardNumber("1225");
//            creditCardPayment1.setPaymentDate(new Date());
//            creditCardPayment1.setAmount(200.2);
//            creditCardPayment1.setExpirationDate("12/2025");
//
//            PayPalPayment1 payPalPayment1 = new PayPalPayment1();
//            payPalPayment1.setAmount(4000.2);
//            payPalPayment1.setPaymentDate(new Date());
//            payPalPayment1.setAccountNumber("1225455");
//
//            session.save(creditCardPayment1);
//            session.save(payPalPayment1);
//
//            System.out.println("creditCardPayment " + creditCardPayment1);
//       System.out.println("payPalPayment " + payPalPayment1);
//
//            tx.commit();

// Demo tableperclass
            CreditCardPayment2 creditCardPayment1 = new CreditCardPayment2();
            creditCardPayment1.setCardNumber("1225");
            creditCardPayment1.setPaymentDate(new Date());
            creditCardPayment1.setAmount(200.2);
            creditCardPayment1.setExpirationDate("12/2025");

            PayPalPayment2 payPalPayment1 = new PayPalPayment2();
            payPalPayment1.setAmount(4000.2);
            payPalPayment1.setPaymentDate(new Date());
            payPalPayment1.setAccountNumber("1225455");

            session.save(creditCardPayment1);
            session.save(payPalPayment1);

            System.out.println("creditCardPayment " + creditCardPayment1);
            System.out.println("payPalPayment " + payPalPayment1);

            tx.commit();


        } catch (Exception ex) {
            if (tx != null) {
                tx.rollback();
                ex.printStackTrace();
            }
        } finally {
            session.close();
            sessionFactory.close();
        }


    }
}
