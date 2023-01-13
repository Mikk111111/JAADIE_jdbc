package com.organization.jdbc;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/classicmodels",
                    "root",
                    "root1");
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery("select * from customers");
            List<Customer> customers = new ArrayList<>();
            while (result.next()) {
                //System.out.println(result.getInt(1)+"|"+result.getString(2);
                Customer customer = new Customer(result.getInt("customerNumber"),
                        result.getString("customerName"),
                        result.getString("phone"),
                        result.getString("city"));
                customers.add(customer);
            }
            customers.forEach(System.out::println);
//            for (Customer elementas : customers){
//                System.out.println(elementas);
//            }
//
//            for (int i=0; i<customers.size(); i++){
//                System.out.println(customers.get(i));
//            }

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
