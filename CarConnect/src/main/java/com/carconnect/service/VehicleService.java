package com.carconnect.service;

import java.util.List;

import com.carconnect.DAO.VehicleDAO;
import com.carconnect.entity.Vehicle;
import com.carconnect.service.Interfaces.IVehicleService;

public class VehicleService implements IVehicleService{
    private VehicleDAO vehicleDAO = new VehicleDAO();

    public boolean registerVehicle(Vehicle vehicle) {
        return vehicleDAO.addVehicle(vehicle);
    }
    
    public Vehicle getVehicleById(int id) {
        return vehicleDAO.getVehicleById(id);
    }
    
    public Vehicle getVehicleByModel(String model)
    {
    	return vehicleDAO.getVehicleByModel(model);
    }

	@Override
	public List<Vehicle> getAvailableVehicles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateVehicle(Vehicle vehicle) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeVehicle(int id) {
		// TODO Auto-generated method stub
		return false;
	}
}