package com.carconnect.service;

import com.carconnect.DAO.ReservationDAO;
import com.carconnect.entity.Reservation;
import com.carconnect.exception.ReservationException;
import com.carconnect.service.Interfaces.IReservationService;

import java.util.List;

public class ReservationService implements IReservationService {
    private final ReservationDAO reservationDAO = new ReservationDAO();

    @Override
    public Reservation getReservationById(int id) {
        Reservation reservation = reservationDAO.getReservationById(id);
        if (reservation == null) {
            throw new ReservationException("Reservation with ID " + id + " not found.");
        }
        return reservation;
    }

    @Override
    public List<Reservation> getReservationsByCustomerId(int customerId) {
        return reservationDAO.getReservationsByCustomerId(customerId);
    }

    @Override
    public boolean createReservation(Reservation reservation) {
        return reservationDAO.createReservation(reservation);
    }

    @Override
    public boolean updateReservation(Reservation reservation) {
        return reservationDAO.updateReservation(reservation);
    }

    @Override
    public boolean cancelReservation(int id) {
        return reservationDAO.cancelReservation(id);
    }
}