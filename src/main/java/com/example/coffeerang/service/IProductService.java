package com.example.coffeerang.service;

import com.example.coffeerang.dto.ProductDTO;

import java.util.List;

public interface IProductService {
    List<ProductDTO> getAll(int pageNumber);
    List<ProductDTO> getByLine(String line,String code ,String name);
    int getCountProduct();
}
