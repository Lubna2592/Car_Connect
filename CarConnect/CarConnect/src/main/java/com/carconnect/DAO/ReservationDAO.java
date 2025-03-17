package com.carconnect.DAO;

import java.sql.*;
import java.util.ArrayList;
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
	    String query = "SELECT * FROM Reservation WHERE ReservationID = ?";
	    try (Connection conn = DBConnUtil.getConnection();
	         PreparedStatement stmt = conn.prepareStatement(query)) {
	        stmt.setInt(1, id);
	        ResultSet rs = stmt.executeQuery();
	        if (rs.next()) {
	            return new Reservation(
	                rs.getInt("ReservationID"),
	                rs.getInt("CustomerID"),
	                rs.getInt("VehicleID"),
	                rs.getDate("StartDate"),
	                rs.getDate("EndDate"),
	                rs.getDouble("TotalCost"),
	                rs.getString("Status")
	            );
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return null; 
	}


	@Override
	public List<Reservation> getReservationsByCustomerId(int customerId) {
	    List<Reservation> reservations = new ArrayList<>();
	    String query = "SELECT * FROM Reservation WHERE CustomerID = ?";
	    try (Connection conn = DBConnUtil.getConnection();
	         PreparedStatement stmt = conn.prepareStatement(query)) {
	        stmt.setInt(1, customerId);
	        ResultSet rs = stmt.executeQuery();
	        while (rs.next()) {
	            reservations.add(new Reservation(
	                rs.getInt("ReservationID"),
	                rs.getInt("CustomerID"),
	                rs.getInt("VehicleID"),
	                rs.getDate("StartDate"),
	                rs.getDate("EndDate"),
	                rs.getDouble("TotalCost"),
	                rs.getString("Status")
	            ));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return reservations; // Empty list if no reservations found
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