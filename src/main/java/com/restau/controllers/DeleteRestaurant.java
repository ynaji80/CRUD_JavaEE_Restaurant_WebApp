package com.restau.controllers;

import com.restau.dao.DAOInstance;
import com.restau.dao.RestaurantDAO;
import com.restau.dao.RestaurantDaoImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "DeleteRestaurant", value = "/DeleteRestaurant")
public class DeleteRestaurant extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.sendRedirect("index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=(int) Integer.parseInt(request.getParameter("id"));

        RestaurantDAO restaurantDAO =null;
        try{
            restaurantDAO= DAOInstance.daoFactory.getRestaurantDAO();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        restaurantDAO.deleteRestaurant(id);
        response.sendRedirect("GetRestaurants");

    }
}
