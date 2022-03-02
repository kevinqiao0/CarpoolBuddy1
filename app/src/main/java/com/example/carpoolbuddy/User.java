package com.example.carpoolbuddy;

import android.widget.EditText;

import java.util.ArrayList;

public class User {
    private String userID;
    private String name;
    private String email;
    private String userType;
    private double priceMultiplier;
    public String password;
    public ArrayList ownedVehicles = new ArrayList();

    public User(String userID, String name, String email, String userType, double priceMultiplier, String password) {
        this.userID = userID;
        this.name = name;
        this.email = email;
        this.userType = userType;
        this.priceMultiplier = priceMultiplier;
        this.password = password;
    }


    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public double getPriceMultiplier() {
        return priceMultiplier;
    }

    public void setPriceMultiplier(double priceMultiplier) {
        this.priceMultiplier = priceMultiplier;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList getOwnedVehicles() {
        return ownedVehicles;
    }

    public void setOwnedVehicles(ArrayList ownedVehicles) {
        this.ownedVehicles = ownedVehicles;
    }

    @Override
    public String toString() {
        return "User{" +
                "userID='" + userID + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", userType='" + userType + '\'' +
                ", priceMultiplier=" + priceMultiplier +
                '}';
    }
}
