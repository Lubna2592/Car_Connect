package com.carconnect.service.Interfaces;
import com.carconnect.entity.*;

public interface ICustomerService {
    Customer getCustomerById(int id);
    Customer getCustomerByUsername(String username);
    boolean authenticate(String username, String password);
    boolean updateCustomer(Customer customer);
    boolean deleteCustomer(int id);
}