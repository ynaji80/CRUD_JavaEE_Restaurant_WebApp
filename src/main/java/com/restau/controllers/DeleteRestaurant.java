package com.restau.controllers;

import com.restau.dao.RestaurantDaoImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteRestaurant", value = "/DeleteRestaurant")
public class DeleteRestaurant extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.sendRedirect("index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=(int) Integer.parseInt(request.getParameter("id"));
        RestaurantDaoImp restaurantDao= new RestaurantDaoImp();
        restaurantDao.deleteRestaurant(id);
        response.sendRedirect("index.jsp");

    }
}
