package org.ncu.hirewheels.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.ncu.hirewheels.entities.Vehicle;
import org.ncu.hirewheels.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hirewheels/v1")
public class VehicleController {
	
	@Autowired
	VehicleService vehicleService;

	@GetMapping(value = "/vehicles")
	public ResponseEntity<List<Map>> getAllVehicles(){
		List<Map> list = new ArrayList<>();
		for(Map v : vehicleService.getAllVehicles().values()) {
			list.add(v);
		}
		return new ResponseEntity<List<Map>>(list, HttpStatus.OK);
	}
}

