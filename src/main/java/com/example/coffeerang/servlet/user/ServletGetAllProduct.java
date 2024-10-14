package com.example.coffeerang.servlet.user;

import com.example.coffeerang.dto.Common;
import com.example.coffeerang.dto.ProductDTO;
import com.example.coffeerang.service.IProductService;
import com.example.coffeerang.service.impl.ProductService;
import com.google.gson.Gson;
import org.json.simple.JSONObject;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ServletGetAllProduct", value = "/ServletGetAllProduct")
public class ServletGetAllProduct extends HttpServlet {
    private IProductService _productService = new ProductService();
    private Gson gson = new Gson();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //List of product
        PrintWriter out = response.getWriter();
        String page = request.getParameter("page");
        int pageNumber =(page == null) ? 0 : Integer.parseInt(page);
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
        Common common = new Common();
        common.setList(list_product);
        common.setPageIndex(pageNumber);
        common.setTotalPage(noOfPages);
        String employeeJsonString = this.gson.toJson(common);
        response.setContentType("application/json");
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(employeeJsonString);
        out.flush();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    private JSONObject retrieveData(Common common) {

        JSONObject json = new JSONObject();
        json.put("totalPage",common.getTotalPage());
        json.put("pageIndex",common.getPageIndex());
        json.put("products",common.getList());
        return json;
    }
}
