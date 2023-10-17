package org.ncu.hirewheels.controller;

import java.util.Map;

import org.ncu.hirewheels.entities.Booking;
import org.ncu.hirewheels.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hirewheels/v1")
public class BookingController {
	

	@Autowired
	BookingService bookingService;
	
//	@PostMapping(path = "/bookings", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<Booking> addBookingDetails(@RequestBody Booking booking) {
//		//@RequestBody = when we send data from client side it converts/ serialize the java object data (here product entity) into json object
//		//@RequestEntity = for doing stuff manually 	
//		Booking b = bookingService.addBooking(booking);
////		Vehicle registeredVehicle = adminService.registerVehicle(vehicle);
//		return new ResponseEntity<>(b, HttpStatus.CREATED);
//	}
	
	@PostMapping(path = "/bookings", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Map> addBookingDetails(@RequestBody Booking booking) {
		//@RequestBody = when we send data from client side it converts/ serialize the java object data (here product entity) into json object
		//@RequestEntity = for doing stuff manually 	
		Map b = bookingService.addBooking(booking);
//		Vehicle registeredVehicle = adminService.registerVehicle(vehicle);
		return new ResponseEntity<>(b, HttpStatus.CREATED);
	}
}
