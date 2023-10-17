package org.ncu.hirewheels.services;

import java.util.Map;

import org.ncu.hirewheels.entities.Input;
import org.ncu.hirewheels.entities.Vehicle;


public interface AdminService {

	public Map<String, Object> registerVehicle(Vehicle vehicle);
	
	public Map<String, Object> changeAvailability(long vehicleId, Input status);
	
}