package org.ncu.hirewheels.entities;

import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.*;


@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", length = 10)
    private Long userId;

    @Column(name = "first_name", nullable = false, length =50)
    private String firstName;

    @Column(name = "last_name", length = 50)
    private String lastName;

    @Size(min = 6, message = "Password must be at least 6 characters long")
    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email",length = 50, nullable = false, unique = true)
    private String email;

    @Column(name = "mobile_no", nullable = false, unique = true, length = 10)
    private String mobileNo;

    @Column(name = "wallet_money", precision = 10, scale = 2, columnDefinition = "NUMERIC(10,2) DEFAULT 10000.00")
    private double walletMoney = 10000.00;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;
    
}
