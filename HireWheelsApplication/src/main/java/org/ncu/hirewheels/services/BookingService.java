package org.ncu.hirewheels.services;

import java.util.Map;

import org.ncu.hirewheels.entities.Booking;

public interface BookingService {	
	
	public Map<String, Object> addBooking(Booking booking);

}
