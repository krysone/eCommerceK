package com.kryscreasy.ecommercek.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Long id;

    @Column(nullable = false, unique = true)
    private String productName;

    @Column
    private String description;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private String category;

}
