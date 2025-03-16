package com.carconnect.service;

import com.carconnect.DAO.CustomerDAO;
import com.carconnect.entity.Customer;
import com.carconnect.service.Interfaces.ICustomerService;

public class CustomerService implements ICustomerService{
    private CustomerDAO customerDAO = new CustomerDAO();

    public boolean registerCustomer(Customer customer) {
        return customerDAO.registerCustomer(customer);
    }

    public boolean authenticateCustomer(String username, String password) {
        Customer customer = customerDAO.getCustomerByUsername(username);
        if (customer != null) {
            return customer.checkPassword(password);
        }
        return false;
    }
    
    public Customer getCustomerById(int id) {
        return customerDAO.getCustomerById(id);
    }
    
    public Customer getCustomerByUsername(String username)
    {
    	return customerDAO.getCustomerByUsername(username);
    }

	@Override
	public boolean authenticate(String username, String password) {
		// TODO Auto-generated method stub
		return false;
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