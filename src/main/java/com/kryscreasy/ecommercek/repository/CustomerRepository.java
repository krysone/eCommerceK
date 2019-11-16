package com.kryscreasy.ecommercek.repository;

import com.kryscreasy.ecommercek.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

//    List<Customer> findAllByCustomerName(String customerName);
    List<Customer> findAll();
}
