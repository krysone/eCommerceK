package com.kryscreasy.ecommercek.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Long id;

    @Basic(optional = false)
    @CreationTimestamp
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date placedAt = new Date();

    @Column
    private String firstname;

    @Column
    private String lastname;

    @Column(nullable = false)
    private String street;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String zip;

    @Column
    private String ccNumber;

    @Column
    private String ccExpiration;

    @Column
    private String ccCVV;

}
