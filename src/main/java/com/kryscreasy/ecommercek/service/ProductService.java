package com.kryscreasy.ecommercek.service;

import com.kryscreasy.ecommercek.dto.CustomerDto;
import com.kryscreasy.ecommercek.dto.ProductDto;
import com.kryscreasy.ecommercek.entity.Customer;
import com.kryscreasy.ecommercek.entity.Product;
import com.kryscreasy.ecommercek.repository.CustomerRepository;
import com.kryscreasy.ecommercek.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Slf4j
@Service
public class ProductService {

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
        dto.setId(product.getId());
        return dto;
    }
    public ProductDto findById(Long prodId){
        ProductDto dto = new ProductDto();
        Optional<Product> prodById = productRepository.findById(prodId);
        if (prodById.isPresent()) {
            dto.setPrice(prodById.get().getPrice());
            dto.setCategory(prodById.get().getCategory());
            dto.setDescription(prodById.get().getDescription());
            dto.setProductName(prodById.get().getProductName());
            dto.setId(prodById.get().getId());
        }
        return dto;
    }
    public boolean existProductById(Long prodId){
        log.info(String.valueOf(prodId));
        if (productRepository.existsById(prodId)){
           return true;
       };
        return false;
    }

    public void updateProduct(ProductDto productDto){
        if (productRepository.existsById(productDto.getId())) {
            productRepository.deleteById(productDto.getId());
            Product entity = new Product();
            entity.setProductName(productDto.getProductName());
            entity.setDescription(productDto.getDescription());
            entity.setCategory(productDto.getCategory());
            entity.setPrice(productDto.getPrice());
            productRepository.save(entity);
        }
    }

}
