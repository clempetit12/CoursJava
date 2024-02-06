package org.example.demo_1.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {
    public static Connection getMysqlConnection() throws SQLException {
        // avec MySql
        String url = "jdbc:mysql://localhost:3306/demo_jdbc";
        String userName = "root";
        String password = "2554";
      Connection connection = DriverManager.getConnection(url,userName,password);
      return connection;
    }
}
