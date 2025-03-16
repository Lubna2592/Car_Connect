package com.carconnect.entity;

import java.util.Date;

public class Payment {
    private int paymentID, reservationID;
    private double amount;
    private Date paymentDate;
    private String paymentMethod, paymentStatus;

    public Payment(int paymentID, int reservationID, double amount, Date paymentDate, String paymentMethod, String paymentStatus) {
        this.paymentID = paymentID;
        this.reservationID = reservationID;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = paymentStatus;
    }

    public int getPaymentID() { return paymentID; }
    public int getReservationID() { return reservationID; }
    public double getAmount() { return amount; }
    public Date getPaymentDate() { return paymentDate; }
    public String getPaymentMethod() { return paymentMethod; }
    public String getPaymentStatus() { return paymentStatus; }
}