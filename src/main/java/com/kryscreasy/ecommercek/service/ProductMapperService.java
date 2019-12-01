package com.kryscreasy.ecommercek.service;

import com.kryscreasy.ecommercek.dto.ProductDto;
import com.kryscreasy.ecommercek.entity.Product;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductMapperService {

    public ProductDto mapEntityToDto(Product product) {
        ProductDto dto = new ProductDto();
        dto.setProductName(product.getProductName());
        dto.setDescription(product.getDescription());
        dto.setCategory(product.getCategory());
        dto.setPrice(product.getPrice());
        dto.setId(product.getId());
        return dto;
    }

    public ProductDto mapDtoToEntity(Product product) {
        ProductDto dto = new ProductDto();
        dto.setProductName(product.getProductName());
        dto.setDescription(product.getDescription());
        dto.setCategory(product.getCategory());
        dto.setPrice(product.getPrice());
        dto.setId(product.getId());
        return dto;
    }
}
