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
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/products")
    public String products(Model model) {
        List<ProductDto> prodList = new ArrayList<ProductDto>();
        prodList = productService.findAll();
        model.addAttribute("productList", prodList);
        model.addAttribute("addProductForm", new ProductDto());
        String forProductSupplyViewOnly = "Supply a new product";
        model.addAttribute("ifInProductSupplyView", forProductSupplyViewOnly);
        return "products";
    }


    @PostMapping("/products/add-new")
    public String addProduct(@ModelAttribute("addProductForm") ProductDto addProductForm) {
//        ProductDto isProductExist = productService.findById(addProductForm.getId());
        log.info(addProductForm.getProductName());
        log.info(String.valueOf(addProductForm.getId()));
//        productService.createProduct(addProductForm);
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
    public String editProduct(@RequestParam(value ="prodEditId", required = false) Long prodEditId, Model model) {
        log.info(String.valueOf(prodEditId));
        ProductDto toBeEditedProd = productService.findById(prodEditId);

        String forProductEditionViewOnly = "Edit the product";
        model.addAttribute("ifInProductEditionView", forProductEditionViewOnly);
        model.addAttribute("addProductForm", toBeEditedProd);

        return "products";
    }
    @GetMapping(value = "/products/delete")
    public String deleteProd(@RequestParam(value ="prodEditId", required = false) Long prodEditId) {
        log.info(String.valueOf(prodEditId));
//        ProductDto toBeDeletedProd = productService.findById(prodEditId);
        productService.deleteProductById(prodEditId);

//        String forProductEditionViewOnly = "Edit the product";
//        model.addAttribute("ifInProductEditionView", forProductEditionViewOnly);
//        model.addAttribute("addProductForm", toBeDeletedProd);

        return "redirect:/products";
    }


    // GET lista wszystkich produktów
    // GET wyświetlenie formularza nowego produktu
    // POST dodanie nowego produktu
    // GET wyświetlenie formularza edycji produktu
    // POST edycja produktu
}
