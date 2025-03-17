package com.carconnect.entity;

import java.util.Date;
import java.time.temporal.ChronoUnit;

public class Reservation {
    private int reservationID, customerID, vehicleID;
    private Date startDate, endDate;
    private double totalCost;
    private String status;

    public Reservation(int reservationID, int customerID, int vehicleID, Date startDate, Date endDate, double totalCost, String status) {
        this.reservationID = reservationID;
        this.customerID = customerID;
        this.vehicleID = vehicleID;
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalCost = totalCost;
        this.status = status;
    }

    public int getReservationID() { return reservationID; }
    public int getCustomerID() { return customerID; }
    public int getVehicleID() { return vehicleID; }
    public Date getStartDate() { return startDate; }
    public Date getEndDate() { return endDate; }
    public double getTotalCost() { return totalCost; }
    public String getStatus() { return status; }
 
    public double calculateTotalCost(double dailyRate) {
        long days = ChronoUnit.DAYS.between(startDate.toInstant(), endDate.toInstant());
        return days * dailyRate;
    }
}