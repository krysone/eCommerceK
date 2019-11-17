package com.kryscreasy.ecommercek.controller;

import com.kryscreasy.ecommercek.dto.ProductDto;
import com.kryscreasy.ecommercek.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Slf4j
@Controller
@RequestMapping("/addProduct")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public String products(Model model) {

        model.addAttribute("addProductForm", new ProductDto());
        return "addProduct";
    }


    @PostMapping
    public String addProduct(@ModelAttribute ProductDto addProductForm) {
        log.info(addProductForm.getProductName());
        productService.createProduct(addProductForm);
        return "redirect:/addProduct";
    }
}
