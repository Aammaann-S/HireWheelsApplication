package org.ncu.hirewheels.services;

import java.util.Map;

import org.ncu.hirewheels.entities.Booking;
import org.ncu.hirewheels.entities.Vehicle;

public interface VehicleService {
	
	public Map<Long, Map> getAllVehicles();
	
	public Map<Long, Vehicle> getAvailableVehicles(Booking booking, long id);


}
