package com.carconnect.DAO.Interfaces;

import com.carconnect.entity.*;

public interface ICustomerDAO {
    boolean registerCustomer(Customer customer);
    Customer getCustomerById(int id);
    Customer getCustomerByUsername(String username);
    boolean updateCustomer(Customer customer);
    boolean deleteCustomer(int id);
}