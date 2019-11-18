package com.kryscreasy.ecommercek.dto;

import lombok.Data;

@Data
public class ProductDto {

    private Long id;
//    @NotBlank ()
//    @Min(2)
//    @Max(255)
    private String productName;

//    @NotBlank
//    @Min(4)
//    @Max(255)
//    @Email
    private String description;

//    @NotBlank
//    @Min(2)
//    @Max(255)
    private double price;

//    @NotBlank
//    @Min(2)
//    @Max(255)
    private String category;



}
