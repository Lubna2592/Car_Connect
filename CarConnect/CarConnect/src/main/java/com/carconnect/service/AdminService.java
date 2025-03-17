package com.carconnect.service;

import com.carconnect.DAO.AdminDAO;
import com.carconnect.entity.Admin;
import com.carconnect.exception.AdminNotFoundException;
import com.carconnect.service.Interfaces.IAdminService;

public class AdminService implements IAdminService{
    private AdminDAO adminDAO = new AdminDAO();

    public boolean registerAdmin(Admin admin) {
        return adminDAO.registerAdmin(admin);
    }

    public boolean authenticateAdmin(String username, String password) {
        Admin admin = adminDAO.getAdminByUsername(username);
        if (admin != null) {
            return admin.checkPassword(password);
        }
        return false;
    }

    public Admin getAdminById(int id) {
        Admin admin = adminDAO.getAdminById(id);
        if (admin == null) {
            throw new AdminNotFoundException("Admin with ID '" + id + "' not found.");
        }
        return admin;
    }

    public Admin getAdminByUsername(String username) {
        Admin admin = adminDAO.getAdminByUsername(username);
        if (admin == null) {
            throw new AdminNotFoundException("Admin with username '" + username + "' not found.");
        }
        return admin;
    }


	@Override
	public boolean authenticate(String username, String password) {
		// TODO Auto-generated method stub
		return false;
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