package com.restau.dao;

import com.restau.extra.DatabaseConnection;
import com.restau.models.Restaurant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RestaurantDaoImp implements RestaurantDAO{
    private Connection con;
    private PreparedStatement ps;
    private String query;
    private ResultSet rs;

    public RestaurantDaoImp() {
        con= DatabaseConnection.getConnected();
    }

    @Override
    public int addRestaurant(Restaurant restaurant) {
        try {
            ps = con.prepareStatement("INSERT INTO restaurant value(null,?,?,?,?,?,?) ");
            ps.setString(1, restaurant.getName());
            ps.setString(2, restaurant.getAddress());
            ps.setString(3, restaurant.getDescription());
            ps.setString(4, restaurant.getFacebookUrl());
            ps.setString(5, restaurant.getLocationUrl());
            ps.setString(6, restaurant.getImage());
            int i =ps.executeUpdate();
            if(i>0){
                return 1;
            }
            else{
                return 0;
            }
        }
        catch (Exception e){
            System.out.println("Connection Error"+e);
        }
        return -1;
    }

    @Override
    public int updateRestaurant(Restaurant restaurant) {
        query="UPDATE restaurant SET name=?, address=?, description=?, facebook_url=?, location_url=?, image=? WHERE id=?";
        try {
            ps= con.prepareStatement(query);
            ps.setString(1,restaurant.getName());
            ps.setString(2,restaurant.getAddress());
            ps.setString(3,restaurant.getDescription());
            ps.setString(4, restaurant.getFacebookUrl());
            ps.setString(5, restaurant.getLocationUrl());
            ps.setString(6, restaurant.getImage());
            ps.setInt(7, restaurant.getId());
            int i =ps.executeUpdate();
            if(i>0){
                return 1;
            }
            else{
                return 0;
            }
        }
        catch (Exception e){
            System.out.println("Connection Error"+e);
        }
        return -1;
    }

    @Override
    public int deleteRestaurant(int id) {
        query="DELETE from restaurant WHERE id=?";
        try {
            ps= con.prepareStatement(query);
            ps.setInt(1, id);
            int i =ps.executeUpdate();
            if(i>0){
                return 1;
            }
            else{
                return 0;
            }
        }
        catch (Exception e){
            System.out.println("Connection Error"+e);
        }
        return -1;
    }

    @Override
    public List<Restaurant> getAllRestaurants() {
        query="SELECT * from restaurant";
        try {
            ps= con.prepareStatement(query);
            rs =ps.executeQuery();
            List <Restaurant> restaurantList = new ArrayList<Restaurant>();
            while(rs.next()){
                Restaurant restaurant =new Restaurant(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7)
                );
                restaurantList.add(restaurant);
            }
            return restaurantList;
        }
        catch (Exception e){
            System.out.println("Connection Error"+e);
        }
        return null;
    }
}
