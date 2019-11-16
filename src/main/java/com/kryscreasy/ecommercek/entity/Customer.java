package com.kryscreasy.ecommercek.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
@Data
@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Long id;

    @Column(nullable = false, unique = true)
    private String customerName;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;
}
