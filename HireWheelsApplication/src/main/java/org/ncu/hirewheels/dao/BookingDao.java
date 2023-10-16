package org.ncu.hirewheels.dao;

import java.sql.Date;

import org.ncu.hirewheels.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookingDao  extends JpaRepository<Booking, Long>{
	
	@Query(value = "SELECT * FROM BOOKING WHERE VEHICLE_ID = ?1 AND (PICKUP_DATE >= ?2 OR DROPOFF_DATE =< ?2)", nativeQuery = true)
	Booking findByVehicleIdAndPickUpDate(Long vehicleid, Date pickup, Date dropoff);
	
	@Query(value = "SELECT * FROM BOOKING WHERE VEHICLE_ID = ?1 AND (PICKUP_DATE >= ?2 OR DROPOFF_DATE =< ?2)", nativeQuery = true)
	Booking findByVehicleIdAndDropOffDate(Long vehicleid, Date dropoff, Date pickup);

}
