package com.carconnect.DAO.Interfaces;
import com.carconnect.entity.*;

public interface IAdminDAO {
    Admin getAdminById(int id);
    Admin getAdminByUsername(String username);
    boolean updateAdmin(Admin admin);
    boolean deleteAdmin(int id);
}