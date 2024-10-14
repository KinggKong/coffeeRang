package com.example.coffeerang.service.impl;

import com.example.coffeerang.dto.ProductDTO;
import com.example.coffeerang.service.IProductService;
import com.example.coffeerang.util.DbConnectHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService implements IProductService {
    @Override
    public List<ProductDTO> getAll(int pageNumber) {
        DbConnectHelper dbConnectHelper = new DbConnectHelper();
        List<ProductDTO> list_product = new ArrayList<>();
        if (pageNumber == 0){
            try {
                Connection connection = dbConnectHelper.openConnectToDB();
                String sql = "select * from products limit 10 offset 0";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()){
                    ProductDTO productDTO = new ProductDTO();
                    productDTO.setProduct_code(resultSet.getString(1));
                    productDTO.setProduct_name(resultSet.getString(2));
                    productDTO.setProduct_line(resultSet.getString(3));
                    productDTO.setLink_image(resultSet.getString(4));
                    System.out.println("----------------------------------------------");
                    list_product.add(productDTO);
                }
                dbConnectHelper.closeConnect(connection);
                return list_product;
            }catch (SQLException e){
                System.out.println("có lỗi xảy ra");
            }
            return list_product;
        }else {
            try {
                Connection connection = dbConnectHelper.openConnectToDB();
                String sql = "select * from products limit ? offset ?";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1,(pageNumber-1));
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()){
                    ProductDTO productDTO = new ProductDTO();
                    productDTO.setProduct_code(resultSet.getString(1));
                    productDTO.setProduct_name(resultSet.getString(2));
                    productDTO.setProduct_line(resultSet.getString(3));
                    productDTO.setLink_image(resultSet.getString(4));
                    System.out.println("----------------------------------------------");
                    list_product.add(productDTO);
                }
                dbConnectHelper.closeConnect(connection);
                return list_product;
            }catch (SQLException e){
                System.out.println("có lỗi xảy ra");
            }
            return list_product;
        }
    }

    @Override
    public List<ProductDTO> getByLine(String line,String code,String name) {
        DbConnectHelper dbConnectHelper = new DbConnectHelper();
        List<ProductDTO> list_product = new ArrayList<>();
        try {
            Connection connection = dbConnectHelper.openConnectToDB();
            String sql = "select * from products where productLine = ? ";
            Map<String,String> params = new HashMap<>();
            if (code != null){
                params.put("code",code);
            }if (name !=null){
                params.put("name",name);
            }
            PreparedStatement preparedStatement = null;
            System.out.println(params.size());
            if (params.size() ==1){
                if (params.get("code") != null){
                    sql += "and productCode =? ";
                     preparedStatement = connection.prepareStatement(sql);
                    preparedStatement.setString(1,line);
                    preparedStatement.setString(2,code);
                }else if (params.get("name") != null){
                    sql += "and productName =? ";
                     preparedStatement = connection.prepareStatement(sql);
                    preparedStatement.setString(1,line);
                    preparedStatement.setString(2,name);
                }
            }else if (params.size() == 0){
                 preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1,line);
            }
            else {
                sql += "and productCode =? and productName =? ";
                 preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1,line);
                preparedStatement.setString(2,code);
                preparedStatement.setString(3,name);
            }
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                ProductDTO productDTO = new ProductDTO();
                productDTO.setProduct_code(resultSet.getString(1));
                productDTO.setProduct_name(resultSet.getString(2));
                productDTO.setProduct_line(resultSet.getString(3));
                System.out.println("----------------------------------------------");
                list_product.add(productDTO);
            }
            dbConnectHelper.closeConnect(connection);
            return list_product;
        }catch (SQLException e){
            System.out.println("có lỗi xảy ra");
        }
        return list_product;
    }

    @Override
    public int getCountProduct() {
        try {
            DbConnectHelper dbConnectHelper = new DbConnectHelper();
            Connection connection = dbConnectHelper.openConnectToDB();
            String sql = "select count(*)total from products";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                return resultSet.getInt("total");
            }
        }catch (Exception e){

        }
        return 0;
    }
}
