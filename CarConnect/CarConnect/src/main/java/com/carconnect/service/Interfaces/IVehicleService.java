package com.carconnect.service.Interfaces;
import java.util.List;
import com.carconnect.entity.Vehicle;

public interface IVehicleService {
    Vehicle getVehicleById(int id);
    Vehicle getVehicleByModel(String model);
    List<Vehicle> getAvailableVehicles();
    boolean updateVehicle(Vehicle vehicle);
    boolean removeVehicle(int id);
}