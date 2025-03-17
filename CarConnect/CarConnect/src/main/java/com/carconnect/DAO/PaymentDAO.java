package com.carconnect.DAO;

import java.sql.*;

import com.carconnect.DAO.Interfaces.IPaymentDAO;
import com.carconnect.entity.Payment;
import com.carconnect.util.DBConnUtil;

public class PaymentDAO implements IPaymentDAO{
    public boolean createPayment(Payment payment) {
        String query = "INSERT INTO Payment (ReservationID, Amount, PaymentDate, PaymentMethod, PaymentStatus) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBConnUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, payment.getReservationID());
            stmt.setDouble(2, payment.getAmount());
            stmt.setTimestamp(3, new Timestamp(payment.getPaymentDate().getTime()));
            stmt.setString(4, payment.getPaymentMethod());
            stmt.setString(5, payment.getPaymentStatus());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

	@Override
	public boolean updatePaymentStatus(int paymentID, String status) {
		// TODO Auto-generated method stub
		return false;
	}
}