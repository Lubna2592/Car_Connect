package com.carconnect.DAO.Interfaces;
import com.carconnect.entity.*;


public interface IPaymentDAO {
    boolean createPayment(Payment payment);
    boolean updatePaymentStatus(int paymentID, String status);
}