package com.kryscreasy.ecommercek.repository;


import com.kryscreasy.ecommercek.entity.OrderLine;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderLineRepository extends JpaRepository<OrderLine, Long> {


}
