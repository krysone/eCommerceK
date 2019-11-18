package com.kryscreasy.ecommercek.controller;

import com.kryscreasy.ecommercek.dto.ProductDto;
import com.kryscreasy.ecommercek.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Slf4j
@Controller
//@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/products")
    public String products(Model model) {
        List<ProductDto> prodList = new ArrayList<ProductDto>();
        prodList = productService.findAll();
        model.addAttribute("productList", prodList);
        model.addAttribute("addProductForm", new ProductDto());
        return "products";
    }


    @PostMapping("/products")
    public String addProduct(@ModelAttribute("addProductForm") ProductDto addProductForm) {
//        ProductDto isProductExist = productService.findById(addProductForm.getId());
        log.info(addProductForm.getProductName());
        log.info(String.valueOf(addProductForm.getId()));
        if (addProductForm.getId() != null){
//        if (productService.existProductById(addProductForm.getId())){
            productService.updateProduct(addProductForm);
        }
        else {
            productService.createProduct(addProductForm);
        }
        log.info(addProductForm.getProductName());
        return "redirect:/products";
    }

//    @GetMapping(value = "/products/edit(id=${product.id})")
    @GetMapping(value = "/products/edit")
    public String editProduct(@RequestParam(value ="prodId", required = false) String prodId, Model model) {
        Long ProdId = Long.parseLong(prodId);
        ProductDto toBeEditedProd = new ProductDto();
        if (!prodId.isEmpty()) {
            toBeEditedProd = productService.findById(ProdId);
        }
        String forProductEditionViewOnly = "Edit the product";
        model.addAttribute("ifInProductEditionView", forProductEditionViewOnly);
        model.addAttribute("addProductForm", toBeEditedProd);

        return "products";
    }


}
