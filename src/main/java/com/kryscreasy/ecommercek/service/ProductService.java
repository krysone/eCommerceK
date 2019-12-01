package com.kryscreasy.ecommercek.service;

import com.kryscreasy.ecommercek.dto.CustomerDto;
import com.kryscreasy.ecommercek.dto.ProductDto;
import com.kryscreasy.ecommercek.entity.Customer;
import com.kryscreasy.ecommercek.entity.Product;
import com.kryscreasy.ecommercek.repository.CustomerRepository;
import com.kryscreasy.ecommercek.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapperService productMapperService;

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
//                .map(this::map)
                .map(productMapperService::mapEntityToDto)
                .collect(Collectors.toList());

    }

    //    public ProductDto map(Product product){
//        ProductDto dto = new ProductDto();
//        dto.setProductName(product.getProductName());
//        dto.setDescription(product.getDescription());
//        dto.setCategory(product.getCategory());
//        dto.setPrice(product.getPrice());
//        dto.setId(product.getId());
//        return dto;
//    }
    public ProductDto findById(Long prodId){
        ProductDto dto = new ProductDto();
        Optional<Product> prodById = productRepository.findById(prodId);
        if (prodById.isPresent()) {
//            dto = productMapperService.mapEntityToDto(prodById);
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
//        if (!prodId.isEmpty()) {
//            toBeEditedProd = productService.findById(ProdId);
//        }
        if (productRepository.existsById(productDto.getId())) {
            Product entity = productRepository.findProductById(productDto.getId());
            entity.setProductName(productDto.getProductName());
            entity.setDescription(productDto.getDescription());
            entity.setCategory(productDto.getCategory());
            entity.setPrice(productDto.getPrice());
            productRepository.save(entity);
        }
    }
    public void deleteProductById(Long prodToBeDeletedId){
        productRepository.deleteById(prodToBeDeletedId);
    }

}
