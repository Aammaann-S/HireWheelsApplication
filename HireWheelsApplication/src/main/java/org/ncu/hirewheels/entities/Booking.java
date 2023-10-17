package org.ncu.hirewheels.entities;

import java.sql.Date;

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
@Table(name = "booking")
@Data
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id", length = 10)
    private Long bookingId;

    @Column(name = "pickup_date", nullable = false)
    private Date pickupDate;

    @Column(name = "dropoff_date", nullable = false)
    private Date dropoffDate;

    @Column(name = "booking_date", nullable = false)
    private Date bookingDate;

    @Column(name = "amount", nullable = false, precision = 10, scale = 2, columnDefinition = "NUMERIC(10,2)")
    private double amount;

    @ManyToOne
    @JoinColumn(name = "location_id", nullable = false)
    private Location location;

    @ManyToOne
    @JoinColumn(name = "vehicle_id", nullable = false)
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

}
