package com.kryscreasy.ecommercek.service;

import com.kryscreasy.ecommercek.dto.ProductDto;
import com.kryscreasy.ecommercek.entity.Product;
import com.kryscreasy.ecommercek.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@SessionScope
@Service
@Slf4j
public class ShoppingCartService {

    private final ProductRepository productRepository;
    private final Map<Long, Integer> shoppingCartProducts;
    private final ProductMapperService productMapperService;

    public void addToShoppingCart(Long shoppingCartProdId) {
//        Map<Long, Integer> shoppingCartProducts = new HashMap<Long, Integer>();
        log.info(String.valueOf(shoppingCartProdId) + " = prod id");
        if (shoppingCartProducts.containsKey(shoppingCartProdId)) {
//                Product prods = productRepository.findProductById(shoppingCartProdId);
            int amount = shoppingCartProducts.get(shoppingCartProdId);
            shoppingCartProducts.replace(shoppingCartProdId, amount + 1);
            log.info(String.valueOf(shoppingCartProducts.get(shoppingCartProdId)));
        } else {
            shoppingCartProducts.put(shoppingCartProdId, 1);
        }
    }

    public Map<ProductDto, Integer> showMyCart() {
        Map<ProductDto, Integer> myCartProducts = new HashMap<>();
        for (Long id : shoppingCartProducts.keySet()) {
            Product prodFromCart = productRepository.findProductById(id);
            ProductDto dto = productMapperService.mapEntityToDto(prodFromCart);
            myCartProducts.put(dto, shoppingCartProducts.get(id));
        }
        return myCartProducts;
    }

    public Map<Long, Integer> showMyCartIdAndAmount() {
        return shoppingCartProducts;
    }

}
