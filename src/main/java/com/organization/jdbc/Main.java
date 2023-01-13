package com.organization.jdbc;
import java.sql.*;
public class Main {
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/classicmodels",
                    "root",
                    "root1");
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery("select * from customers");

            while (result.next()) System.out.println(result.getInt(1)+"|"+result.getString(2));
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
