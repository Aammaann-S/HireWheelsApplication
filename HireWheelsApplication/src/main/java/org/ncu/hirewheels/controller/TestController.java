package org.ncu.hirewheels.controller;

import java.util.ArrayList;
import java.util.List;

import org.ncu.hirewheels.entities.Booking;
import org.ncu.hirewheels.entities.Role;
import org.ncu.hirewheels.entities.User;
import org.ncu.hirewheels.entities.Vehicle;
import org.ncu.hirewheels.services.AdminService;
import org.ncu.hirewheels.services.BookingService;
import org.ncu.hirewheels.services.RoleService;
import org.ncu.hirewheels.services.UserService;
import org.ncu.hirewheels.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

	@Autowired
	UserService userService;

	@Autowired
	RoleService roleService;
	
	@Autowired
	AdminService adminService;
	
	@Autowired
	VehicleService vehicleService;
	
	@Autowired
	BookingService bookingService;

    @PostMapping("/create")
    public ResponseEntity<Role> createRole(@RequestParam("roleName") String roleName) {
        Role createdRole = roleService.createRole(roleName);
        return new ResponseEntity<>(createdRole, HttpStatus.CREATED);
    }
    
    @PostMapping(path = "/createUser")
	public String registerUserDetails(@RequestBody User user) {
		//@RequestBody = when we send data from client side it converts/ serialize the java object data (here product entity) into json object
		//@RequestEntity = for doing stuff manually 	
		String msg = userService.createUser(user);
		return msg;
	}
	
	@GetMapping(value = "/fetchUsers")
	public ResponseEntity<List<User>> getUsers(){
		List<User> list = new ArrayList<>();
		for(User u : userService.getAllUsers().values()) {
			list.add(u);
		}
		return new ResponseEntity<List<User>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/login")
	public ResponseEntity<User> getUserDetails(@RequestParam("email") String email, @RequestParam("password") String password) {
//	@PostMapping(path = "/user/login")
//	public ResponseEntity<User> getUserDetails(@RequestBody String email,@RequestBody String password){
		User access =  userService.getUser(email, password);
		return new ResponseEntity<User>(access, HttpStatus.OK);
	}
	
	
	@GetMapping(value = "/getAllVehicles")
	public ResponseEntity<List<Vehicle>> getAllVehicles(){
		List<Vehicle> list = new ArrayList<>();
		for(Vehicle v : vehicleService.getAllVehicles().values()) {
			list.add(v);
		}
		return new ResponseEntity<List<Vehicle>>(list, HttpStatus.OK);
	}
	

	@PostMapping(value = "/availableVehicles/{categryId}")
	public ResponseEntity<List<Vehicle>> getAvailableVehicles(@RequestBody Booking booking, @PathVariable Long categryId){
		List<Vehicle> list = new ArrayList<>();
		for(Vehicle v : vehicleService.getAvailableVehicles(booking,categryId).values()) {
			list.add(v);
		}
		return new ResponseEntity<List<Vehicle>>(list, HttpStatus.OK);
	}
	   
    
    
}