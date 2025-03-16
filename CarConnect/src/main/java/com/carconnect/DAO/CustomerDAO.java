package com.carconnect.DAO;

import java.sql.*;

import com.carconnect.DAO.Interfaces.ICustomerDAO;
import com.carconnect.entity.Customer;
import com.carconnect.util.DBConnUtil;

public class CustomerDAO implements ICustomerDAO{
    public boolean registerCustomer(Customer customer) {
        String query = "INSERT INTO Customer (FirstName, LastName, Email, PhoneNumber, Address, Username, PasswordHash) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, customer.getFirstName());
            stmt.setString(2, customer.getLastName());
            stmt.setString(3, customer.getEmail());
            stmt.setString(4, customer.getPhoneNumber());
            stmt.setString(5, customer.getAddress());
            stmt.setString(6, customer.getUsername());
            stmt.setString(7, customer.getPasswordHash());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Customer getCustomerByUsername(String username) {
        String query = "SELECT * FROM Customer WHERE Username = ?";
        try (Connection conn = DBConnUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Customer(
                    rs.getInt("CustomerID"),
                    rs.getString("FirstName"),
                    rs.getString("LastName"),
                    rs.getString("Email"),
                    rs.getString("PhoneNumber"),
                    rs.getString("Address"),
                    rs.getString("Username"),
                    rs.getString("PasswordHash")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public Customer getCustomerById(int id) {
        String query = "SELECT * FROM Customer WHERE CustomerID = ?";
        try (Connection conn = DBConnUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Customer(
                    rs.getInt("CustomerID"),
                    rs.getString("FirstName"),
                    rs.getString("LastName"),
                    rs.getString("Email"),
                    rs.getString("PhoneNumber"),
                    rs.getString("Address"),
                    rs.getString("Username"),
                    rs.getString("PasswordHash")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

	@Override
	public boolean updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteCustomer(int id) {
		// TODO Auto-generated method stub
		return false;
	}
}