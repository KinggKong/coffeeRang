package com.example.coffeerang.servlet.user;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

@WebServlet(name = "trang-chu", value = "/trang-chu")
@MultipartConfig
public class HomeServlet extends HttpServlet {
    private String path_upload ="C:\\Users\\ADMIN\\Desktop\\exam\\CoffeeRang\\target\\CoffeeRang-1.0-SNAPSHOT\\static";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        request.getRequestDispatcher("home_view.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //upload
        for (Part part : request.getParts()) {
            String fileName = extractFileName(part);
            fileName = new File(fileName).getName();
            //save add
            part.write(this.getFolderUpload().getAbsolutePath() + File.separator + fileName);
        }
    }
    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "";
    }
    public File getFolderUpload() {
        File folderUpload = new File(path_upload+ "/uploads");
        if (!folderUpload.exists()) {
            folderUpload.mkdirs();
        }
        return folderUpload;
    }
}
