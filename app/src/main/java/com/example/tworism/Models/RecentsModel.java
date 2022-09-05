package com.example.tworism.Models;
//Model de prueba
public class RecentsModel {
    String placeName;
    String city;
    String price;

    public RecentsModel(String placeName, String city, String price) {
        this.placeName = placeName;
        this.city = city;
        this.price = price;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
