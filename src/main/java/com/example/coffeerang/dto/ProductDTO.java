package com.example.coffeerang.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
        private String product_code;
        private String product_name;
        private String product_line;
        private String link_image;

}
