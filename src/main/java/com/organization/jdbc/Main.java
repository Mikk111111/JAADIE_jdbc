package com.organization.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CustomerService customerService = new CustomerService();
        List<Customer> customers = new ArrayList<>();
        customers = customerService.getAllCustomer();
        customers.forEach(System.out::println);

    }
}
