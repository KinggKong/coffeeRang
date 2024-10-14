package com.example.coffeerang.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Common {
    private int totalPage;
    private int totalItem;
    private int pageIndex;
    private String message;
    private List<ProductDTO> list = new ArrayList<ProductDTO>();
}
