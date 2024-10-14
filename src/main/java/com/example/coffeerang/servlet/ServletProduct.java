package com.example.coffeerang.servlet;

import com.example.coffeerang.dto.ProductDTO;
import com.example.coffeerang.service.IProductService;
import com.example.coffeerang.service.impl.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@WebServlet(name = "ServletProduct", value = "/ServletProduct")
public class ServletProduct extends HttpServlet {

    private IProductService _productService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pageNumber = Integer.parseInt(request.getParameter("page"));
        List<ProductDTO> list_product = new ArrayList<>();
        int pagesie = 10;
        if (pageNumber !=0){
            list_product= _productService.getAll(pageNumber);
        }else {
            list_product = _productService.getAll(0);
        }
        int count = _productService.getCountProduct();

        int noOfPages = (int)Math.ceil(count * 1.0
                / pagesie);



        //getall line
            Set<String> list_line = new HashSet<>();
            list_product.stream().forEach(x ->list_line.add(x.getProduct_line()));
            request.setAttribute("list_product",list_product);
            request.setAttribute("list_line",list_line);
            request.setAttribute("selected_line","");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("home.jsp");
            requestDispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
