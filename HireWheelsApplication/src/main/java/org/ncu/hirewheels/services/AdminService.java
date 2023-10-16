package org.ncu.hirewheels.services;

import java.util.Map;

import org.ncu.hirewheels.entities.Input;
import org.ncu.hirewheels.entities.Vehicle;


public interface AdminService {

	public Vehicle registerVehicle(Vehicle vehicle);
	
	public Vehicle changeAvailability(long vehicleId, Input status);
	
}