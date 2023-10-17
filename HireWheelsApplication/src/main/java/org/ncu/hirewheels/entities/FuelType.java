package org.ncu.hirewheels.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "fuel_type")
@Data
public class FuelType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fuel_type_id", length = 10)
    private Long fuelTypeId;

    @Column(name = "fuel_type", nullable = false, unique = true, length = 50)
    private String fuelType;
}
