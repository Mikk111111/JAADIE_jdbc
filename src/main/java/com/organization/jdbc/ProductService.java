package com.organization.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductService {
    Repository rep = new Repository();
    public List<Product> products = new ArrayList<>();
    public List<Product> getAllProduct() {
        try(Connection connection = rep.getConnection()){
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM classicmodels.products");
            while (result.next()){
                Product product = new Product(result.getString("productCode"),
                        result.getString("productName"),
                        result.getString("productLine"),
                        result.getString("productScale"),
                        result.getString("productVendor"),
                        result.getString("productDescription"),
                        result.getInt("quantityInStock"),
                        result.getDouble("buyPrice"),
                        result.getDouble("MSRP"));
                products.add(product);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return products;
    }
}
