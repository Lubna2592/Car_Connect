package com.carconnect.DAO;

import java.sql.*;
import java.util.List;

import com.carconnect.DAO.Interfaces.IVehicleDAO;
import com.carconnect.entity.Vehicle;
import com.carconnect.util.DBConnUtil;

public class VehicleDAO implements IVehicleDAO{
    public boolean addVehicle(Vehicle vehicle) {
        String query = "INSERT INTO Vehicle (Model, Make, Year, Color, RegistrationNumber, Availability, DailyRate, FuelType, SeatingCapacity) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, vehicle.getModel());
            stmt.setString(2, vehicle.getMake());
            stmt.setInt(3, vehicle.getYear());
            stmt.setString(4, vehicle.getColor());
            stmt.setString(5, vehicle.getRegistrationNumber());
            stmt.setBoolean(6, vehicle.isAvailability());
            stmt.setDouble(7, vehicle.getDailyRate());
            stmt.setString(8, vehicle.getFuelType());
            stmt.setInt(9, vehicle.getSeatingCapacity());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public Vehicle getVehicleById(int id) {
        String query = "SELECT * FROM Vehicle WHERE VehicleID = ?";
        try (Connection conn = DBConnUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Vehicle(
                    rs.getInt("VehicleID"),
                    rs.getString("Model"),
                    rs.getString("Make"),
                    rs.getInt("Year"),
                    rs.getString("Color"),
                    rs.getString("RegistrationNumber"),
                    rs.getBoolean("Availability"),
                    rs.getDouble("DailyRate"),
                    rs.getString("FuelType"),
                    rs.getInt("SeatingCapacity")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public Vehicle getVehicleByModel(String Model) {
        String query = "SELECT * FROM Vehicle WHERE Model = ?";
        try (Connection conn = DBConnUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, Model);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Vehicle(
                    rs.getInt("VehicleID"),
                    rs.getString("Model"),
                    rs.getString("Make"),
                    rs.getInt("Year"),
                    rs.getString("Color"),
                    rs.getString("RegistrationNumber"),
                    rs.getBoolean("Availability"),
                    rs.getDouble("DailyRate"),
                    rs.getString("FuelType"),
                    rs.getInt("SeatingCapacity")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

	@Override
	public List<Vehicle> getAvailableVehicles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateVehicle(Vehicle vehicle) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeVehicle(int id) {
		// TODO Auto-generated method stub
		return false;
	}
}