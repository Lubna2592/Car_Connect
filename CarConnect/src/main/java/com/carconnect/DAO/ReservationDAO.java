package com.carconnect.DAO;

import java.sql.*;
import java.util.List;

import com.carconnect.DAO.Interfaces.IReservationDAO;
import com.carconnect.entity.Reservation;
import com.carconnect.util.DBConnUtil;

public class ReservationDAO implements IReservationDAO {
    public boolean createReservation(Reservation reservation) {
        String query = "INSERT INTO Reservation (CustomerID, VehicleID, StartDate, EndDate, TotalCost, Status) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, reservation.getCustomerID());
            stmt.setInt(2, reservation.getVehicleID());
            stmt.setTimestamp(3, new Timestamp(reservation.getStartDate().getTime()));
            stmt.setTimestamp(4, new Timestamp(reservation.getEndDate().getTime()));
            stmt.setDouble(5, reservation.getTotalCost());
            stmt.setString(6, reservation.getStatus());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

	@Override
	public Reservation getReservationById(int id) {
		return null;
	}

	@Override
	public List<Reservation> getReservationsByCustomerId(int customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateReservation(Reservation reservation) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean cancelReservation(int id) {
		// TODO Auto-generated method stub
		return false;
	}
}