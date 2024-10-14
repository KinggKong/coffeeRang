package com.example.coffeerang.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnectHelper {
    public Connection openConnectToDB() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/cy_be?useSSL=false";
        String password = "1234";
        String username = "root";
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
        return connection;
    }
    public void closeConnect(Connection connection) throws SQLException {

        connection.close();
    }

}
