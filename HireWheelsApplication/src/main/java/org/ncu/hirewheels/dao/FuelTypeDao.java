package org.ncu.hirewheels.dao;

import org.ncu.hirewheels.entities.FuelType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuelTypeDao  extends JpaRepository<FuelType, Long>{
	
	FuelType findByFuelType(String fuelType);
	
	FuelType findByFuelTypeId(Long fuelTypeId);


}
