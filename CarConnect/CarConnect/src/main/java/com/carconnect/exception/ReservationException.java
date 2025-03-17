package com.carconnect.exception;

public class ReservationException extends RuntimeException {
	public ReservationException() {
        super("Reservation not found"); 
    }
	
    public ReservationException(String message) {
        super(message);
    }
}