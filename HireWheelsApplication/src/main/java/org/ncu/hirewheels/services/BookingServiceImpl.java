package org.ncu.hirewheels.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.ncu.hirewheels.dao.BookingDao;
import org.ncu.hirewheels.dao.CityDao;
import org.ncu.hirewheels.dao.LocationDao;
import org.ncu.hirewheels.dao.UserDao;
import org.ncu.hirewheels.dao.VehicleDao;
import org.ncu.hirewheels.entities.Booking;
import org.ncu.hirewheels.entities.City;
import org.ncu.hirewheels.entities.Location;
import org.ncu.hirewheels.entities.User;
import org.ncu.hirewheels.entities.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImpl implements BookingService{

	@Autowired
    private BookingDao bookingDao;

    @Autowired
    private UserDao userDao;
    
    @Autowired
    private VehicleDao vehicleDao;
    
    @Autowired
	LocationDao locationDao;
	
	@Autowired
	CityDao cityDao;
	
	public Map<String, Object> addBooking(Booking booking) {
		
        // Get the user's account balance
        User user = userDao.findByUserId(booking.getUser().getUserId());
        Vehicle vehicle = vehicleDao.findByVehicleId(booking.getVehicle().getVehicleId());
        Location location = locationDao.findByLocationId(booking.getLocation().getLocationId());
        if (location == null) {
            System.out.println("Inavailable at the location. Please Check With Admin");

        };
        
        double userBalance = user.getWalletMoney();
        double bookingAmount = booking.getAmount();
        if (userBalance < bookingAmount) {
            System.out.println("Insufficient Balance. Please Check With Admin");
            return null;
        }
        double deductedBalance = userBalance - bookingAmount;
        user.setWalletMoney(deductedBalance);

        // Saveing the updated user's information
        userDao.save(user);
        
        // setting value in booking table
        booking.setUser(user);
        booking.setLocation(location);
        vehicle.setLocation(location);
        booking.setVehicle(vehicle);
        // Saveing the booking to the database
        Booking savedBooking = bookingDao.save(booking);

		Map<String, Object> output = new HashMap<String, Object>();
		output.put("bookingId", savedBooking.getBookingId());
		output.put("pickupDate", savedBooking.getPickupDate());
		output.put("dropoffDate", savedBooking.getDropoffDate());
		output.put("bookingDate", savedBooking.getBookingDate());
		output.put("amount", savedBooking.getAmount());
		output.put("locationId", savedBooking.getLocation().getLocationId());
		output.put("vehicleId", savedBooking.getVehicle().getVehicleId());
		output.put("userId", savedBooking.getUser().getUserId());
        
        return output;
    }
	
}
