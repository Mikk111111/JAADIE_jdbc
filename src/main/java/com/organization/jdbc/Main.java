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
        try {
            Properties properties = new Properties();
            FileInputStream fileInputStream = new FileInputStream("./src/main/resources/db.properties");

            properties.load(fileInputStream);

            String url = properties.getProperty("db.url");
            String username = properties.getProperty("db.username");
            String password = properties.getProperty("db.password");

            Connection conn = DriverManager.getConnection(
                    url,
                    username,
                    password
            );

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
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();;
        }


    }
}
