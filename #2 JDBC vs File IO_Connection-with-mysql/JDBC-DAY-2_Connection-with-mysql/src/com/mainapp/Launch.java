package com.mainapp;

import java.sql.Connection;
import java.sql.DriverManager;

public class Launch {

    static void main() {

        // CONNECT WITH DRIVER
        try {
            // MySQL DRIVER LOADED AND REGISTERED
            Class.forName("com.mysql.cj.jdbc.Driver"); // THIS IS OPTIONAL SINCE JDBC4.0+

            String url = "jdbc:mysql://localhost:3306";
            String user = "root";
            String password = "";

            // FACTORY DESIGN PATTERN
            //         OBJ     JDBC API      STATIC CLASS
            Connection conn = DriverManager.getConnection(url,user,password);
            System.out.println(conn);
            System.out.println("Connected to database successfully");

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }
}
