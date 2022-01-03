package com.restau.models;

public class Restaurant {
    private int id;
    private String name;
    private String address;
    private String description;
    private String facebookUrl;
    private String locationUrl;
    private String image;

    public Restaurant() {
    }

    public Restaurant(int id, String name, String address, String description, String facebookUrl, String locationUrl, String image) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.description = description;
        this.facebookUrl = facebookUrl;
        this.locationUrl = locationUrl;
        this.image = image;
    }

    public String getFacebookUrl() {
        return facebookUrl;
    }

    public void setFacebookUrl(String facebookUrl) {
        this.facebookUrl = facebookUrl;
    }

    public String getLocationUrl() {
        return locationUrl;
    }

    public void setLocationUrl(String locationUrl) {
        this.locationUrl = locationUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
