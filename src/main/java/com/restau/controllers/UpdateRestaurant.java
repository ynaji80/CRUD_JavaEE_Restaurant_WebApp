package com.restau.controllers;

import com.restau.dao.RestaurantDaoImp;
import com.restau.models.Restaurant;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;

@WebServlet(name = "UpdateRestaurant", value = "/UpdateRestaurant")
@MultipartConfig

public class UpdateRestaurant extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd;
        RestaurantDaoImp restaurantDao =new RestaurantDaoImp();
        Integer id = Integer.parseInt(request.getParameter("id")) ;
        String name = (String) request.getParameter("name");
        String address = (String) request.getParameter("address");
        String description = (String) request.getParameter("description");
        String facebookUrl = (String) request.getParameter("facebook");
        String locationUrl = (String) request.getParameter("location");
        Part imagePart = request.getPart("image");
        System.out.println("part is :"+imagePart);
        String imageFileName= extractFileName(imagePart);
        System.out.println(imageFileName);
        String savePath= "C:\\Users\\najiy\\IdeaProjects\\mini_projet\\src\\main\\webapp\\img"+ File.separator + imageFileName;
        System.out.println(savePath);
        File fileSaveDir= new File(savePath);
        imagePart.write(savePath+File.separator);
        Restaurant restaurant=new Restaurant();
        restaurant.setId(id);
        restaurant.setName(name);
        restaurant.setAddress(address);
        restaurant.setDescription(description);
        restaurant.setFacebookUrl(facebookUrl);
        restaurant.setLocationUrl(locationUrl);
        restaurant.setImage(savePath);
        restaurantDao.updateRestaurant(restaurant);
        request.setAttribute("restaurant",restaurant);
        response.sendRedirect("index.jsp");
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
}
