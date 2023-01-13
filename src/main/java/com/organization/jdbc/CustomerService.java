package com.organization.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerService {
    Repository rep = new Repository();
    public List<Customer> getAllCustomer() {
        List<Customer> customers = new ArrayList<>();
        try(Connection connection =rep.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("select * from customers");
            while (result.next()) {
                Customer customer = new Customer(result.getInt("customerNumber"),
                        result.getString("customerName"),
                        result.getString("phone"),
                        result.getString("city"));
                customers.add(customer);
            }
//          for (Customer elementas : customers){System.out.println(elementas);}
//          for (int i=0; i<customers.size(); i++){System.out.println(customers.get(i));}
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }
}
