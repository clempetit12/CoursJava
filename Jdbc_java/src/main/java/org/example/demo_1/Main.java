package org.example;

import org.example.demo_1.utils.ConnectionUtils;

import java.sql.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Test connection

        try{
            Connection connection = ConnectionUtils.getMysqlConnection();
            if(connection != null) {
                System.out.println("Connection ok");
            } else {
                System.out.println("connection ko");
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }

        Scanner scanner = new Scanner(System.in);
        Connection connection = null;
        try {
            // création de la connexion
            connection = ConnectionUtils.getMysqlConnection();
            System.out.println("connexion ok");
            System.out.println("Merci de saisir le prénom : ");
            String firstName = scanner.nextLine();
            System.out.println("Merci de saisir le nom : ");
            String lastName = scanner.nextLine();
            // Une requête pour l'insertion de données faille de sécurité car on peut injecter dans les variables prenom et nom d'autres requetes comme création new utilisateur avec tous les accès
            // faille sql injection
            String request = "INSERT INTO persons (first_name,last_name) VALUES (' " + firstName + " ', '" + lastName + " ')";

            // première solution => execution d'une requête sans retour objet statement

            Statement statement = connection.createStatement();
            boolean res = statement.execute(request);
            System.out.println("Requête exécutée");
            System.out.println(res);

// deuxieme solution avec une requête préparée
            // version sans récupération de l'id
             String request = "INSERT INTO persons (first_name,last_name) VALUES (? , ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(request);
            preparedStatement.setString(1,firstName);
            preparedStatement.setString(2, lastName);
            // si on valide la requete sera injectée 2 fois car execute et executeUpdate
            preparedStatement.execute(); // retour boolean
            int nbRows = preparedStatement.executeUpdate(); // retour int pour récupérer nombre de lignes
            System.out.println("Nombre de lignes " + nbRows);

// version avec récupération de l'id
            String request = "INSERT INTO persons (first_name,last_name) VALUES (? , ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(request,Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,firstName);
            preparedStatement.setString(2, lastName);
            int nbRows = preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys(); // méthode pour récupérer l'id
            System.out.println("Nombre de lignes " + nbRows);
            if (resultSet.next()){
                System.out.println(resultSet.getInt(1));
            }


            // Avec une requête de lecture

            String request = "SELECT * FROM persons";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(request);
            while (resultSet.next()){
                System.out.println(resultSet.getInt("id")+ ") " +resultSet.getString("first_name") + " , " + resultSet.getString("last_name") );
            }

            statement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            // finally pour cloturer base de donnée
        } finally {
            // Fermer la connection à la bdd
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}