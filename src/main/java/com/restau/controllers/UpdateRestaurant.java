package com.restau.controllers;

import com.restau.dao.DAOInstance;
import com.restau.dao.RestaurantDAO;
import com.restau.dao.RestaurantDaoImp;
import com.restau.models.Restaurant;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.SQLException;
import java.util.Date;

@WebServlet(name = "UpdateRestaurant", value = "/UpdateRestaurant")
@MultipartConfig

public class UpdateRestaurant extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd;

        RestaurantDAO restaurantDAO =null;
        try{
            restaurantDAO= DAOInstance.daoFactory.getRestaurantDAO();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        Integer id = Integer.parseInt(request.getParameter("id")) ;
        String name = (String) request.getParameter("name");
        String address = (String) request.getParameter("address");
        String description = (String) request.getParameter("description");
        String facebookUrl = (String) request.getParameter("facebook");
        String locationUrl = (String) request.getParameter("location");
        Part imagePart = request.getPart("image");
        System.out.println("part is :"+imagePart);
        String imageFileName= extractFileName(imagePart);
        Date d= new Date();
        String dd=String.valueOf(d.getTime());
        String savePath=
                "C:\\Users\\najiy\\IdeaProjects\\mini_projet\\src\\main\\webapp\\img"+ File.separator + dd + imageFileName;
        String savePath2=
                "C:\\Users\\najiy\\IdeaProjects\\mini_projet\\target\\mini_projet-1.0-SNAPSHOT\\img"+ File.separator+dd+imageFileName;
        File fileSaveDir= new File(savePath);
        if(fileSaveDir.exists()!=true) {
            imagePart.write(savePath + File.separator);
            File fileSaveDir2= new File(savePath2);
            copyFile(fileSaveDir, fileSaveDir2);
        };
        Restaurant restaurant=new Restaurant();
        restaurant.setId(id);
        restaurant.setName(name);
        restaurant.setAddress(address);
        restaurant.setDescription(description);
        restaurant.setFacebookUrl(facebookUrl);
        restaurant.setLocationUrl(locationUrl);
        restaurant.setImage(savePath);
        restaurantDAO.updateRestaurant(restaurant);
        response.sendRedirect("GetRestaurants");

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
    private static void copyFile(File source, File dest) throws IOException {
        Files.copy(source.toPath(), dest.toPath());
    }
}
