package org.example;

import org.example.utils.DatabaseManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Transaction {
    public static void main(String[] args) {
        Connection connection = DatabaseManager.getConnection();
        try{

            // Désactive l'autocommit pour les transactions car considere toute requete comme valide
            connection.setAutoCommit(false);
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO persons (first_name, last_name) VALUES ('Mohamed', 'Aijou')");
            statement.executeUpdate("UPDATE persons SET last_name = 'Aijjou' WHERE first_names= 'Mohamed'");
          /*  if (nbRows == 1) {
                connection.commit();
                System.out.println("Transaction validée");
            } else {
                connection.rollback();
                System.out.println("Transaction annulée");
            }*/
        }catch (SQLException e) {
            System.out.println(e.getMessage());
            try {
                connection.rollback();
                System.out.println("transaction annullée");
            } catch (SQLException er) {
                System.out.println(er.getMessage());
            }
        } finally {
            DatabaseManager.closeConnection();
        }
    }
}
