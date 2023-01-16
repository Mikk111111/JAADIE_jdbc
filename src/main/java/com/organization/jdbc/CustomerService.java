package com.organization.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerService {
    Repository rep = new Repository();
    List<Customer> customers = new ArrayList<>();
    public List<Customer> getAllCustomer() {
        try {
            Connection connection =rep.getConnection() ;
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("select * from customers");
            while (result.next()) {
                Customer customer = new Customer(
                        result.getInt("customerNumber"),
                        result.getString("customerName"),
                        result.getString("phone"),
                        result.getString("city"));
                customers.add(customer);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    public void createCustomer(Customer customer) {
        String sql = "INSERT INTO customers (" +
                "customerNumber, customerName, contactLastName, contactFirstName, " +
                "phone, addressLine1, city, country)VALUES(?,?,?,?,?,?,?,?)";
        try(PreparedStatement preparedStatement = rep.getConnection().prepareStatement(sql)) {
            preparedStatement.setInt(1, customer.getCustomerNumber());
            preparedStatement.setString(2, customer.getCustomerName());
            preparedStatement.setString(3, customer.getContactLastName());
            preparedStatement.setString(4, customer.getContactFirstName());
            preparedStatement.setString(5, customer.getPhone());
            preparedStatement.setString(6, customer.getAddressLine1());
            preparedStatement.setString(7, customer.getCity());
            preparedStatement.setString(8, customer.getCountry());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
