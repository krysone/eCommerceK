package com.kryscreasy.ecommercek.service;

import com.kryscreasy.ecommercek.dto.OrderDto;
import com.kryscreasy.ecommercek.dto.OrderLineDto;
import com.kryscreasy.ecommercek.entity.Order;
import com.kryscreasy.ecommercek.entity.OrderLine;
//import com.kryscreasy.ecommercek.repository.OrderLineRepository;
import com.kryscreasy.ecommercek.repository.OrderLineRepository;
import com.kryscreasy.ecommercek.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderLineRepository orderListRepository;

    //    @Transactional(Transactional.TxType.MANDATORY)
    public void placeOrder(OrderDto orderDto, Map<Long, Integer> myCartIdAndAmount) {
        Order orderEntity = new Order();
        orderEntity.setFirstname(orderDto.getFirstname());
        orderEntity.setLastname(orderDto.getLastname());
        orderEntity.setZip(orderDto.getZip());
        orderEntity.setCity(orderDto.getCity());
        orderEntity.setStreet(orderDto.getStreet());
        orderEntity.setCcNumber(orderDto.getCcNumber());
        orderEntity.setCcExpiration(orderDto.getCcExpiration());
        orderEntity.setCcCVV(orderDto.getCcCVV());
        orderRepository.save(orderEntity);
        for (Map.Entry<Long, Integer> record : myCartIdAndAmount.entrySet()) {
            OrderLine orderLineEntity = new OrderLine();
            orderLineEntity.setProdId(record.getKey());
            orderLineEntity.setAmount(record.getValue());
            orderLineEntity.setOrder(orderEntity);
            orderListRepository.save(orderLineEntity);
        }

    }


}
