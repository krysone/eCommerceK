package com.kryscreasy.ecommercek.dto;

import lombok.Data;

@Data
public class CategoryDto {

    private Long id;

    private String name;

    private CategoryDto parent;

    private CategoryDto child;
}
