package org.ncu.hirewheels.dao;

import org.ncu.hirewheels.entities.Location;

//import javax.tools.DocumentationTool.Location;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationDao extends JpaRepository<Location, Long>{
	
	 public Location findByLocationId(long locationId);


}
