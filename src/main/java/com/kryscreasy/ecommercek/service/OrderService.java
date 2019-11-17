package com.kryscreasy.ecommercek.service;

import com.kryscreasy.ecommercek.dto.OrderDto;
import com.kryscreasy.ecommercek.entity.Order;
import com.kryscreasy.ecommercek.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public void placeOrder(OrderDto orderDto){
        Order entity = new Order();
        entity.setFirstname(orderDto.getFirstname());
        entity.setLastname(orderDto.getLastname());
        entity.setZip(orderDto.getZip());
        entity.setCity(orderDto.getCity());
        entity.setStreet(orderDto.getStreet());
        entity.setCcNumber(orderDto.getCcNumber());
        entity.setCcExpiration(orderDto.getCcExpiration());
        entity.setCcCVV(orderDto.getCcCVV());
        orderRepository.save(entity);
    }
}
