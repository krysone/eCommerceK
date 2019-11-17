package com.kryscreasy.ecommercek.service;

import com.kryscreasy.ecommercek.dto.CustomerDto;
import com.kryscreasy.ecommercek.dto.ProductDto;
import com.kryscreasy.ecommercek.entity.Customer;
import com.kryscreasy.ecommercek.entity.Product;
import com.kryscreasy.ecommercek.repository.CustomerRepository;
import com.kryscreasy.ecommercek.repository.ProductRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

//    private final PasswordEncoder passwordEncoder;
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void createProduct(ProductDto productDto){
        Product entity = new Product();
        entity.setProductName(productDto.getProductName());
        entity.setDescription(productDto.getDescription());
        entity.setCategory(productDto.getCategory());
        entity.setPrice(productDto.getPrice());
        productRepository.save(entity);
    }
    public List<ProductDto> findAll() {
        return productRepository.findAll().stream()
                .map(this::map)
                .collect(Collectors.toList());

    }
    public ProductDto map(Product product){
        ProductDto dto = new ProductDto();
        dto.setProductName(product.getProductName());
        dto.setDescription(product.getDescription());
        dto.setCategory(product.getCategory());
        dto.setPrice(product.getPrice());
        return dto;
    }

}
