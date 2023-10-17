package org.ncu.hirewheels.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "vehicle_subcategory")
@Data
public class VehicleSubcategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vehicle_subcategory_id", length = 10)
    private Long vehicleSubcategoryId;

    @Column(name = "vehicle_subcategory_name", nullable = false, unique = true, length = 50)
    private String vehicleSubcategoryName;

    @Column(name = "price_per_day", nullable = false, precision = 10, scale = 2, columnDefinition = "NUMERIC(10,2)")
    private double pricePerDay;

    @ManyToOne
    @JoinColumn(name = "vehicle_category_id", nullable = false)
    private VehicleCategory vehicleCategory;
}
