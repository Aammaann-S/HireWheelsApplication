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
@Table(name = "location")
@Data
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "location_id", length = 10)
    private Long locationId;

    @Column(name = "location_name", nullable = false, length = 50)
    private String locationName;

    @Column(name = "address", nullable = false, length = 100)
    private String address;

    @Column(name = "pincode", nullable = false, length = 6)
    private String pincode;

    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false)
    private City city;
}

