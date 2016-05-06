package com.example.daniel.newmap;

/**
 * Created by Daniel on 4/29/2016.
 */
import com.google.android.gms.maps.model.LatLng;

import java.util.HashMap;

/**
 * Created by Kevin-ASUS on 4/27/2016.
 */
public class FoodCart {

    private String name;



    private String cartID;
    HashMap<String, Double> menu;
    private String address;
    private String description;
    private String cuisine;
    private double latitude;
    private double longitude;
    private LatLng position;




    public FoodCart(String cartID, String name, String cuisine, String description, HashMap<String, Double> menu, String address, LatLng position)
    {
        this.cartID = cartID;
        this.menu = menu;
        this.name = name;
        this.cuisine = cuisine;
        this.description = description;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.position = new LatLng(latitude, longitude);
    }

    public String getCartID(){ return cartID ; }

    //public void setCartID(String cartID) { this.cartID = cartID; }

    public String getName() {
        return name;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getItemPrice(String item) {
        return menu.get(item);
    }

    public LatLng getPosition() {
        return position;
    }
    public void setPosition(LatLng position) {
        this.position = position;
    }
}
