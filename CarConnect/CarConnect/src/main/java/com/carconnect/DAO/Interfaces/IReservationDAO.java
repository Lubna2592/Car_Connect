package com.carconnect.DAO.Interfaces;
import com.carconnect.entity.*;
import java.util.List;

public interface IReservationDAO {
    boolean createReservation(Reservation reservation);
    Reservation getReservationById(int id);
    List<Reservation> getReservationsByCustomerId(int customerId);
    boolean updateReservation(Reservation reservation);
    boolean cancelReservation(int id);
}