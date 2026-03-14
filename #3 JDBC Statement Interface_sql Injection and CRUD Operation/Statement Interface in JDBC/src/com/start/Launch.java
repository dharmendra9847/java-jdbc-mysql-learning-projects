package com.start;

import java.sql.Connection;
import java.sql.DriverManager;

import static java.lang.Class.forName;

public class Launch {

    static void main() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306";
            String user = "root";
            String password = "";

            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println(con);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
