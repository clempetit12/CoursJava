package org.example;

import org.example.utils.DatabaseManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;

// Batch : réunir plusieurs requetes et les faire en une seule fois
public class MultipleRows {
    public static void main(String[] args) {
        Connection connection = DatabaseManager.getConnection();
        PreparedStatement preparedStatement = null;
        try{
            String request = "INSERT INTO persons (first_name, last_name) VALUES (?, ?)";
            preparedStatement = connection.prepareStatement(request);
            String [][] stagiaires = {
                    {"Rémi", "Jospin",},
                    {"Adil", "Hanoun",},
                    {"Maxime", "Morvan",},
            };
            // Insertion des stagiaires en bdd

            for (String[] stagiaire: stagiaires) {
                preparedStatement.setString(1,stagiaire[0]);
                preparedStatement.setString(2,stagiaire[1]);
                // Ajouter la requête au batch
                preparedStatement.addBatch();
            }

            // Execution de la requête batch
          int[] nbRows =   preparedStatement.executeBatch();

            System.out.println("Nombres de lignes insérées : " + nbRows.length );
            preparedStatement.close();
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            DatabaseManager.closeConnection();
        }
    }
}
