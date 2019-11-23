package com.kryscreasy.ecommercek.controller;

import com.kryscreasy.ecommercek.dto.ProductDto;
import com.kryscreasy.ecommercek.dto.ShoppingDto;
import com.kryscreasy.ecommercek.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/shopping")
@RequiredArgsConstructor
public class ShoppingController {

    private final ProductService productService;

    @GetMapping
    public String chooseProducts(Model model) {
        model.addAttribute("shoppingCart", new ShoppingDto());
        List<ProductDto> allProducts = productService.findAll();
        model.addAttribute("allProducts", allProducts);
        return "shopping";
    }

    @PostMapping
    public String shoppingCart(@ModelAttribute("allProducts") ShoppingDto allProducts, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "shopping";
        }
        return "redirect:/orders/current";
    }
}
