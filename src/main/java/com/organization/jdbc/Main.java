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
        ProductLineService productLineService = new ProductLineService();
        ProductService productService = new ProductService();

//        Customer customer01 = new Customer(508,
//                "Name01",
//                "Homer",
//                "Simpson",
//                "+370 666 66666",
//                "Somewhere",
//                "Vilnius",
//                "LT");
//        customerService.createCustomer(customer01);

        //List<Customer> customers = customerService.getAllCustomer();
        //List<ProductLine> productLines = productLineService.getAllProductLine();
        List<Product> products = productService.getAllProduct();

        products.forEach(System.out::println);
        //customers.forEach(System.out::println);
        //productLines.forEach(System.out::println);



    }
}
