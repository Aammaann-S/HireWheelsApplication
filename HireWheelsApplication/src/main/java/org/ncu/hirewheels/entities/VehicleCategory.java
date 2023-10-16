package org.ncu.hirewheels.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "vehicle_category")
@Data
public class VehicleCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vehicle_category_id", length = 10)
    private Long vehicleCategoryId;

    @Column(name = "vehicle_category_name", nullable = false, unique = true, length = 50)
    private String vehicleCategoryName;
}
