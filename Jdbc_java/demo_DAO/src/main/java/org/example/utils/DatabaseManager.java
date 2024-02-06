package org.example.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class DatabaseManager {

    private static final String URI = "jdbc:mysql://localhost:3306/demo_jdbc";
    private static final String USER = "root";
    private static final String PASSWORD = "2554";
    private static Connection connection;

    // réalisation d'un singleton avec constructeur par défaut
    private DatabaseManager() {

    }

    public static Connection getConnection() {
        if (connection == null) {
            System.out.println("création d'une connection");
            try {
                connection = DriverManager.getConnection(URI, USER, PASSWORD);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            System.out.println("Fermeture d'une connection");
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        finally {
                connection = null;
            }
            }
    }

}
