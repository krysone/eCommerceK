package com.kryscreasy.ecommercek.controller;

import com.kryscreasy.ecommercek.dto.ProductDto;
import com.kryscreasy.ecommercek.dto.ShoppingDto;
import com.kryscreasy.ecommercek.service.ProductService;
import com.kryscreasy.ecommercek.service.ShoppingCartService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/shopping")
@RequiredArgsConstructor
public class ShoppingController {

    private final ProductService productService;
    private final ShoppingCartService shoppingCartService;

    @GetMapping
    public String chooseProducts(Model model) {
        model.addAttribute("shoppingCart", new ShoppingDto());
        List<ProductDto> allProducts = productService.findAll();
        model.addAttribute("allProducts", allProducts);
        return "shopping";
    }

    @GetMapping("/my-cart")
    public String shoppingCart(@RequestParam(value ="addToCartId", required = false) Long addToCartId) {
//        if (bindingResult.hasErrors()) {
//            return "shopping";
//        }
        log.info(String.valueOf(addToCartId));
        shoppingCartService.addToShoppingCart(addToCartId);
        return "redirect:/shopping";
    }
}
