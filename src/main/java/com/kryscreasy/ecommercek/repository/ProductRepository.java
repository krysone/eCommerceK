package com.kryscreasy.ecommercek.repository;

import com.kryscreasy.ecommercek.entity.Customer;
import com.kryscreasy.ecommercek.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByProductName(String productName);
    List<Product> findAll();
    List<Product> findProductById(Long id);


}
