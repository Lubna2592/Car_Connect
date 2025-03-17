package com.carconnect.exception;

public class AdminNotFoundException extends RuntimeException {
	public AdminNotFoundException() {
        super("Admin not found"); 
    }
    public AdminNotFoundException(String message) {
        super(message);
    }
}