package com.organization.jdbc;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        Repository rep = new Repository();
        try(Connection connection = rep.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("select * from customers");
            List<Customer> customers = new ArrayList<>();
            while (result.next()) {
                Customer customer = new Customer(result.getInt("customerNumber"),
                        result.getString("customerName"),
                        result.getString("phone"),
                        result.getString("city"));
                customers.add(customer);
            }
            customers.forEach(System.out::println);
//          for (Customer elementas : customers){System.out.println(elementas);}
//          for (int i=0; i<customers.size(); i++){System.out.println(customers.get(i));}
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
