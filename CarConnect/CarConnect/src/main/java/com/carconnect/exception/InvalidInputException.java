package com.carconnect.exception;

public class InvalidInputException extends RuntimeException {
	public InvalidInputException() {
        super("Enter the valid input."); 
    }
    public InvalidInputException(String message) {
        super(message);
    }
}