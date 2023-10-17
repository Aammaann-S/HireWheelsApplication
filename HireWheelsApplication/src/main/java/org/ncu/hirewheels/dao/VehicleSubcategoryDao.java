package org.ncu.hirewheels.dao;

import org.ncu.hirewheels.entities.VehicleSubcategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleSubcategoryDao extends JpaRepository<VehicleSubcategory, Long>{

	public VehicleSubcategory findByVehicleSubcategoryId(long vehicleSubcategoryId);
	

}
