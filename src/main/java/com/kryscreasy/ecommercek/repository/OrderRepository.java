package com.kryscreasy.ecommercek.repository;

import com.kryscreasy.ecommercek.entity.Order;
import com.kryscreasy.ecommercek.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findAll();
    List<Order> findAllByZipAndCityAndStreet(String zip, String city, String street);
}
