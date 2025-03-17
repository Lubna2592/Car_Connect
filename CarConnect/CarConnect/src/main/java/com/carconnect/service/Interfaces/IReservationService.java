package com.carconnect.service.Interfaces;

import java.util.List;

import com.carconnect.entity.Reservation;

public interface IReservationService {
    Reservation getReservationById(int id);
    List<Reservation> getReservationsByCustomerId(int customerId);
    boolean createReservation(Reservation reservation);
    boolean updateReservation(Reservation reservation);
    boolean cancelReservation(int id);
}