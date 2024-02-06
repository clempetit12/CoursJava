package org.example.demo_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main1 {
    public static void main(String[] args) {
        // connection à ma bdd dom_jdbc mySQL numero port par defaut 3306
        String url = "jdbc:mysql://localhost:3306/demo_jdbc";

        try{
            Connection connection = DriverManager.getConnection(url,"root","2554");
            if(connection != null){
                System.out.println("connexion ok");
            } else {
                System.out.println("connexion nok !!!");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        // Meilleure pratique mettre la connexion dans une classe à part
    }
    }


