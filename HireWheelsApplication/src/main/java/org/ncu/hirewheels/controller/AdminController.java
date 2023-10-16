package org.ncu.hirewheels.controller;


import org.ncu.hirewheels.entities.Input;
import org.ncu.hirewheels.entities.Vehicle;
import org.ncu.hirewheels.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hirewheels/v1")
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	@PostMapping(path = "/vehicles", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Vehicle> registerVehicleDetails(@RequestBody Vehicle vehicle) {
		//@RequestBody = when we send data from client side it converts/ serialize the java object data (here product entity) into json object
		//@RequestEntity = for doing stuff manually 	
		Vehicle v = adminService.registerVehicle(vehicle);
		return new ResponseEntity<>(v, HttpStatus.CREATED);
//		Vehicle registeredVehicle = adminService.registerVehicle(vehicle);
//        return new ResponseEntity<>(registeredVehicle, HttpStatus.CREATED);
	}
	

	@PutMapping(path = "/vehicles/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Vehicle> changeAvailability(@PathVariable Long id, @RequestBody Input status) {
		Vehicle v = adminService.changeAvailability(id, status);

		return new ResponseEntity<>(v, HttpStatus.ACCEPTED);
    }
}
