package com.carconnect.service;

import java.util.Date;

import com.carconnect.DAO.PaymentDAO;
import com.carconnect.entity.Payment;
import com.carconnect.service.Interfaces.IPaymentService;

public class PaymentService implements IPaymentService{
    private PaymentDAO paymentDAO = new PaymentDAO();

    public boolean processPayment(int reservationID, double amount, String paymentMethod) {
        Payment payment = new Payment(0, reservationID, amount, new Date(), paymentMethod, "Completed");
        return paymentDAO.createPayment(payment);
    }

	@Override
	public boolean refundPayment(int paymentID) {
		// TODO Auto-generated method stub
		return false;
	}
}