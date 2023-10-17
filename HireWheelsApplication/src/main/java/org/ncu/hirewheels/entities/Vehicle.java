package org.ncu.hirewheels.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;

@Entity
@Table(name = "vehicle")
@Data
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vehicle_id", length = 10)
    private Long vehicleId;

    @Column(name = "vehicle_model", nullable = false, length = 50)
    private String vehicleModel;

    @Column(name = "vehicle_number", nullable = false, length = 10)
    private String vehicleNumber;

    @Column(name = "color", nullable = false, length = 50)
    private String color;

    @Column(name = "availability_status", nullable = false, length = 1)
    private Integer availabilityStatus;

    @Column(name = "vehicle_image_url", nullable = false, length = 500)
    private String vehicleImageUrl;

    @ManyToOne
    @JoinColumn(name = "vehicle_subcategory_id")
    private VehicleSubcategory vehicleSubcategory;

    @ManyToOne
    @JoinColumn(name = "location_id", nullable = false)
    private Location location;

    @ManyToOne
    @JoinColumn(name = "fuel_type_id", nullable = false)
    private FuelType fuelType;

}
