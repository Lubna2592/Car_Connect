package com.carconnect.entity;

import org.mindrot.jbcrypt.BCrypt;

public class Admin {
    private int adminID;
    private String firstName, lastName, email, phoneNumber, username, passwordHash, role;

    public Admin(int adminID, String firstName, String lastName, String email, String phoneNumber, String username, String password, String role) {
        this.adminID = adminID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.username = username;
        this.passwordHash = hashPassword(password);
        this.role = role;
    }

    public int getAdminID() { return adminID; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getEmail() { return email; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getUsername() { return username; }
    public String getPasswordHash() { return passwordHash; }
    public String getRole() { return role; }

    private String hashPassword(String plainTextPassword) {
        return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt(12));
    }

    public boolean checkPassword(String plainTextPassword) {
        return BCrypt.checkpw(plainTextPassword, this.passwordHash);
    }
}
