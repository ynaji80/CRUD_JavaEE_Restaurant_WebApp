package com.restau.controllers;

import com.restau.dao.DAOInstance;
import com.restau.dao.RestaurantDAO;
import com.restau.models.Restaurant;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "GetRestaurants", value = "/GetRestaurants")
public class GetRestaurants extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RestaurantDAO restaurantDAO =null;
        try{
            restaurantDAO= DAOInstance.daoFactory.getRestaurantDAO();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        List<Restaurant> restaurantList=null;
        HttpSession session= request.getSession();
        restaurantList=restaurantDAO.getAllRestaurants();
        session.setAttribute("restaurantList",restaurantList);
        response.sendRedirect("index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
