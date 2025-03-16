package com.carconnect.DAO;

import java.sql.*;

import com.carconnect.DAO.Interfaces.IAdminDAO;
import com.carconnect.entity.Admin;
import com.carconnect.util.DBConnUtil;

public class AdminDAO implements IAdminDAO{
    public boolean registerAdmin(Admin admin) {
        String query = "INSERT INTO Admin (FirstName, LastName, Email, PhoneNumber, Username, PasswordHash, Role) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, admin.getFirstName());
            stmt.setString(2, admin.getLastName());
            stmt.setString(3, admin.getEmail());
            stmt.setString(4, admin.getPhoneNumber());
            stmt.setString(5, admin.getUsername());
            stmt.setString(6, admin.getPasswordHash());
            stmt.setString(7, admin.getRole());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Admin getAdminByUsername(String username) {
        String query = "SELECT * FROM Admin WHERE Username = ?";
        try (Connection conn = DBConnUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Admin(
                    rs.getInt("AdminID"),
                    rs.getString("FirstName"),
                    rs.getString("LastName"),
                    rs.getString("Email"),
                    rs.getString("PhoneNumber"),
                    rs.getString("Username"),
                    rs.getString("PasswordHash"),
                    rs.getString("Role")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

	@Override
	public Admin getAdminById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteAdmin(int id) {
		// TODO Auto-generated method stub
		return false;
	}
}