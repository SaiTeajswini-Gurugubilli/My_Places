package com.example.mobility.myplaces;

/**
 * Created by Mobility on 03/04/17.
 */

public class NearByPlaces {
    private String placeName;
    private String phoneNumber;
    private float rating;
    private double latitude,longitude;

    public NearByPlaces(String placeName, String phoneNumber, float rating, double latitude, double longitude) {
        this.placeName = placeName;
        this.phoneNumber = phoneNumber;
        this.rating = rating;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public NearByPlaces(String placeName, float likelihood, String phonenumber, float rating) {

        this.placeName = placeName;
        this.phoneNumber = phonenumber;
        this.rating = rating;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }
/*
    public String getPhoneNumber() {
        return  phoneNumber;
    }

    public void setPhoneNumber(String image) {
        this. phoneNumber = image;
    }*/


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String  rating) {
        this.phoneNumber = rating;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}
