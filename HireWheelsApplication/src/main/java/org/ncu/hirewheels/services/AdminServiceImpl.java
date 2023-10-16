package org.ncu.hirewheels.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.ncu.hirewheels.dao.CityDao;
import org.ncu.hirewheels.dao.FuelTypeDao;
import org.ncu.hirewheels.dao.LocationDao;
import org.ncu.hirewheels.dao.VehicleDao;
import org.ncu.hirewheels.dao.VehicleSubcategoryDao;
import org.ncu.hirewheels.entities.City;
import org.ncu.hirewheels.entities.FuelType;
import org.ncu.hirewheels.entities.Input;
import org.ncu.hirewheels.entities.Location;
import org.ncu.hirewheels.entities.Role;
import org.ncu.hirewheels.entities.User;
import org.ncu.hirewheels.entities.Vehicle;
import org.ncu.hirewheels.entities.VehicleSubcategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	VehicleDao vehicleDao;
	
	@Autowired
	LocationDao locationDao;
	
	@Autowired
	CityDao cityDao;

	@Autowired
	FuelTypeDao fuelTypeDao;
	
	@Autowired
	VehicleSubcategoryDao vehicleSubcategoryDao;


	@Override
	public Vehicle registerVehicle(Vehicle vehicle) {
		
        VehicleSubcategory vehicleSubcategory = vehicleSubcategoryDao.findByVehicleSubcategoryId(vehicle.getVehicleSubcategory().getVehicleSubcategoryId());
        Location location = locationDao.findByLocationId(vehicle.getLocation().getLocationId());
        FuelType fuelType = fuelTypeDao.findByFuelTypeId(vehicle.getFuelType().getFuelTypeId());

        System.out.println("Vehicle");
        System.out.println(vehicle);

        vehicle.setAvailabilityStatus(1);
        vehicle.setVehicleSubcategory(vehicleSubcategory);
        vehicle.setLocation(location);
        vehicle.setFuelType(fuelType);
        
        // Saving the vehicle
        Vehicle v = vehicleDao.save(vehicle);
		return v;
	}

	@Override
	public Vehicle changeAvailability(long vehicleId, Input status) {
		
		Vehicle vehicle = vehicleDao.findByVehicleId(vehicleId);
		System.out.println(status.getAvailabilityStatus());

//		If were needed to toggle instead of using input
//        int currentAvailabilityStatus = vehicle.getAvailabilityStatus();
//        int newAvailabilityStatus = (currentAvailabilityStatus == 1) ? 0 : 1;

		int newAvailabilityStatus = status.getAvailabilityStatus();
        // Update the availability status of the vehicle
        vehicle.setAvailabilityStatus(newAvailabilityStatus);

        // Saving the updated vehicle to the database
        vehicleDao.save(vehicle);
        System.out.println(vehicle.getAvailabilityStatus());
        
        return vehicle;
	}
	
}
