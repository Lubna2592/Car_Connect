package com.carconnect.service.Interfaces;
import com.carconnect.entity.Admin;

public interface IAdminService {
    Admin getAdminById(int id);
    Admin getAdminByUsername(String username);
    boolean authenticate(String username, String password);
    boolean updateAdmin(Admin admin);
    boolean deleteAdmin(int id);
}