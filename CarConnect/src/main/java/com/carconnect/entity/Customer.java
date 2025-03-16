package com.carconnect.entity;

import org.mindrot.jbcrypt.BCrypt;

public class Customer {
    private int customerID;
    private String firstName, lastName, email, phoneNumber, address, username, passwordHash;

    public Customer(int customerID, String firstName, String lastName, String email, String phoneNumber, String address, String username, String password) {
        this.customerID = customerID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.username = username;
        this.passwordHash = hashPassword(password);
    }

    public int getCustomerID() { return customerID; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getEmail() { return email; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getAddress() { return address; }
    public String getUsername() { return username; }
    public String getPasswordHash() { return passwordHash; }

    private String hashPassword(String plainTextPassword) {
        return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt(12));
    }

    public boolean checkPassword(String plainTextPassword) {
        return BCrypt.checkpw(plainTextPassword, this.passwordHash);
    }
}