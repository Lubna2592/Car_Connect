package com.carconnect.entity;

public class Vehicle {
    private int vehicleID;
    private String model, make, color, registrationNumber;
    private int year, seatingCapacity;
    private boolean availability;
    private double dailyRate;
    private String fuelType;

    public Vehicle(int vehicleID, String model, String make, int year, String color, String registrationNumber, boolean availability, double dailyRate, String fuelType, int seatingCapacity) {
        this.vehicleID = vehicleID;
        this.model = model;
        this.make = make;
        this.year = year;
        this.color = color;
        this.registrationNumber = registrationNumber;
        this.availability = availability;
        this.dailyRate = dailyRate;
        this.fuelType = fuelType;
        this.seatingCapacity = seatingCapacity;
    }

    public int getVehicleID() { return vehicleID; }
    public String getModel() { return model; }
    public String getMake() { return make; }
    public int getYear() { return year; }
    public String getColor() { return color; }
    public String getRegistrationNumber() { return registrationNumber; }
    public boolean isAvailability() { return availability; }
    public double getDailyRate() { return dailyRate; }
    public String getFuelType() { return fuelType; }
    public int getSeatingCapacity() { return seatingCapacity; }
}