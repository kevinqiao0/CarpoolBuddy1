package com.example.carpoolbuddy;

import java.io.Serializable;
import java.util.ArrayList;

public class Vehicle implements Serializable {

    private String owner;
    private String model;
    private String vehicleID;
    private String vehicleType;
    private int capacity;
    private boolean open;
    private double basePrice;
    ArrayList ridersUIDsList = new ArrayList();

    public Vehicle(){};

    public Vehicle(String owner, String model, String vehicleID, String vehicleType, int capacity, boolean open, double basePrice) {
        this.owner = owner;
        this.model = model;
        this.vehicleID = vehicleID;
        this.vehicleType = vehicleType;
        this.capacity = capacity;
        this.open = open;
        this.basePrice = basePrice;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(String vehicleID) {
        this.vehicleID = vehicleID;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public Double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "owner='" + owner + '\'' +
                ", model='" + model + '\'' +
                ", vehicleID='" + vehicleID + '\'' +
                ", vehicleType='" + vehicleType + '\'' +
                ", capacity=" + capacity +
                ", open=" + open +
                ", basePrice=" + basePrice +
                '}';
    }
}
