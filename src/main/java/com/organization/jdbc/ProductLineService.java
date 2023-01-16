package com.organization.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductLineService {
    Repository rep = new Repository();
    List<ProductLine> productLines= new ArrayList<>();
    public List<ProductLine> getAllProductLine(){
        try(Connection connection = rep.getConnection()) {
            ResultSet result = connection.createStatement().executeQuery("SELECT productLine,textDescription,htmlDescription FROM classicmodels.productLines");
            while (result.next()){
                ProductLine  productLine = new ProductLine(result.getString("productLine"),
                        result.getString("textDescription"),
                        result.getString("htmlDescription"));
                productLines.add(productLine);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return productLines;
    }
}
