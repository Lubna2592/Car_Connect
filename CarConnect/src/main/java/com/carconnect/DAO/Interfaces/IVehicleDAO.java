package com.carconnect.DAO.Interfaces;
import com.carconnect.entity.*;
import java.util.List;

public interface IVehicleDAO {
    List<Vehicle> getAvailableVehicles();
    Vehicle getVehicleById(int id);
    Vehicle getVehicleByModel(String model);
    boolean updateVehicle(Vehicle vehicle);
    boolean removeVehicle(int id);
}