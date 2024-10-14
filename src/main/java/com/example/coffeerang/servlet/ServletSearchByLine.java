package com.example.coffeerang.servlet;

import com.example.coffeerang.dto.ProductDTO;
import com.example.coffeerang.service.IProductService;
import com.example.coffeerang.service.impl.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@WebServlet(name = "ServletSearchByLine", value = "/ServletSearchByLine")
public class ServletSearchByLine extends HttpServlet {
    private IProductService _productService = new ProductService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String line_selected = request.getParameter("selected_line");
            String search_code = request.getParameter("input_search_code");
            String search_name = request.getParameter("input_search_name");

            List<ProductDTO> list = _productService.getByLine(line_selected,search_code,search_name);
            request.setAttribute("list_product",list);
            List<ProductDTO> list_product = _productService.getAll(0);
            Set<String> list_line = new HashSet<>();
            list_product.stream().forEach(x ->list_line.add(x.getProduct_line()));
            request.setAttribute("list_line",list_line);
            request.setAttribute("selected_line",line_selected);
                //service để xử vấn đề trả dữ liệu theo line
           request.getRequestDispatcher("home.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
