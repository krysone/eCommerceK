package com.kryscreasy.ecommercek.dto;

import lombok.Data;

@Data
public class OrderLineDto {
//    private Long orderId;

    private Long prodId;

    private Integer amount;
}
