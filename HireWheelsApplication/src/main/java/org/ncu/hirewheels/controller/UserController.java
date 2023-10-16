package org.ncu.hirewheels.controller;

import java.util.ArrayList;
import java.util.List;

import org.ncu.hirewheels.entities.Role;

//import java.util.ArrayList;
//import java.util.List;

import org.ncu.hirewheels.entities.User;
import org.ncu.hirewheels.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class UserController {
	
	@Autowired
	UserService userService;

	@PostMapping(path = "/user/saveUser")
	public String saveUserDetails(@RequestBody User user) {
		//@RequestBody = when we send data from client side it converts/ serialize the java object data (here product entity) into json object
		//@RequestEntity = for doing stuff manually 	
		String msg = userService.createUser(user);
		return msg;
	}
	
	@GetMapping(value = "/user/fetchUsers")
	public ResponseEntity<List<User>> getUsers(){
		List<User> list = new ArrayList<>();
		for(User product : userService.getAllUsers().values()) {
			list.add(product);
		}
//		List<Product> list = (List<Product>) productService.fetchAllProducts().values();
		return new ResponseEntity<List<User>>(list, HttpStatus.OK);
	}
	
	
	@GetMapping("/user/login")
	public ResponseEntity<User> getUserDetails(@RequestParam("email") String email, @RequestParam("password") String password) {
//	@PostMapping(path = "/user/login")
//	public ResponseEntity<User> getUserDetails(@RequestBody String email,@RequestBody String password){
		User access =  userService.getUser(email, password);
		return new ResponseEntity<User>(access, HttpStatus.OK);
	}

}