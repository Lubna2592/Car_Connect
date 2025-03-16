package com.carconnect.service.Interfaces;

public interface IPaymentService {
    boolean processPayment(int reservationID, double amount, String paymentMethod);
    boolean refundPayment(int paymentID);
}
