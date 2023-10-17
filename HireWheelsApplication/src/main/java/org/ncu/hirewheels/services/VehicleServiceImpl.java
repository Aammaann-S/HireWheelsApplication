package org.ncu.hirewheels.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ncu.hirewheels.dao.BookingDao;
import org.ncu.hirewheels.dao.LocationDao;
import org.ncu.hirewheels.dao.VehicleCategoryDao;
import org.ncu.hirewheels.dao.VehicleDao;
import org.ncu.hirewheels.dao.VehicleSubcategoryDao;
import org.ncu.hirewheels.entities.Booking;
import org.ncu.hirewheels.entities.Location;
import org.ncu.hirewheels.entities.Vehicle;
import org.ncu.hirewheels.entities.VehicleCategory;
import org.ncu.hirewheels.entities.VehicleSubcategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleServiceImpl implements VehicleService{
	
	@Autowired
	VehicleDao vehicleDao;
	
	@Autowired
	VehicleSubcategoryDao vehicleSubcategoryDao;
	
	@Autowired
	VehicleCategoryDao vehicleCategoryDao;
	
	@Autowired
	BookingDao bookingDao;
	
	@Autowired
	LocationDao locationDao;
	
	@Override
	public Map<Long, Map> getAllVehicles() {
		// TODO Auto-generated method stub
		List<Vehicle> list =  vehicleDao.findAll();
		Map<Long, Map> map = new HashMap<Long, Map>();
		for(Vehicle v: list) {
			System.out.println(v);
			
//			return v;
	        Map<String, Object> output = new HashMap<String, Object>();
			output.put("vehicleId", v.getVehicleId());
			output.put("vehicleModel", v.getVehicleModel());
			output.put("vehicleNumber", v.getVehicleNumber());
			output.put("vehicleSubCategoryId", v.getVehicleSubcategory().getVehicleSubcategoryId());
			output.put("color", v.getColor());
			output.put("fuelTypeId", v.getFuelType().getFuelTypeId());
			output.put("locationId", v.getLocation().getLocationId());
			output.put("vehicleImageUrl", v.getVehicleImageUrl());
			output.put("availabilityStatus", v.getAvailabilityStatus());
			output.put("pricePerDay", v.getVehicleSubcategory().getPricePerDay());
			System.out.println("------------------------=====");
			System.out.println(output);
//	        return output;
			
			map.put(v.getVehicleId(), output);
		}
		return map;
	}

	@Override
	public Map<Long, Vehicle> getAvailableVehicles(Booking tobook, long categryId) {
		// TODO Auto-generated method stub
//		Vehicle vehicle = vehicleDao.findByVehicleId(booking.getVehicle().getVehicleId());
//		VehicleSubcategory vehicleSubcategory = vehicleSubcategoryDao.findByVehicleSubcategoryId(vehicle.getVehicleSubcategory().getVehicleSubcategoryId());
//		VehicleCategory vehicleCategory = vehicleCategoryDao.findByVehicleCategoryId(vehicleSubcategory.getVehicleCategory().getVehicleCategoryId());
		VehicleCategory vehicleCategory = vehicleCategoryDao.findByVehicleCategoryId(categryId);
		Location location = locationDao.findByLocationId(tobook.getLocation().getLocationId());

		tobook.setLocation(location);

		System.out.println("vehicleCategory");
		System.out.println(vehicleCategory);


		List<Vehicle> list =  vehicleDao.findByVehicleSubcategoryVehicleCategory(vehicleCategory);
		System.out.println("List");
		System.out.println(list);
		
		Map<Long, Vehicle> map = new HashMap<Long, Vehicle>();
		for(Vehicle p: list) {
			System.out.println("test1");

			if(p.getAvailabilityStatus()==1 && p.getLocation()==tobook.getLocation())
			{
				System.out.println("test2");
				System.out.println(tobook.getPickupDate());
				System.out.println(tobook.getDropoffDate());
				Booking c = bookingDao.findByVehicleIdAndPickUpDate(p.getVehicleId(), tobook.getPickupDate(), tobook.getDropoffDate());
				Booking d = bookingDao.findByVehicleIdAndDropOffDate(p.getVehicleId(), tobook.getDropoffDate(), tobook.getPickupDate());
				System.out.println(c);
				System.out.println(d);
				if(c == d)
				{
					if (p.getVehicleId() == tobook.getVehicle().getVehicleId())
					{
						System.out.println("test4");
						map.put(p.getVehicleId(), p);
					}
					System.out.println("test3");
				}
			}
		}
		return map;
	}
}
