package com.restau.dao;

import com.restau.models.Restaurant;

import java.util.List;

public interface RestaurantDAO {
    public List <Restaurant> getAllRestaurants();
    public int addRestaurant(Restaurant restaurant);
    public int updateRestaurant(Restaurant restaurant);
    public int deleteRestaurant(int id);
}
