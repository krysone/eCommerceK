package com.kryscreasy.ecommercek.controller;

import com.kryscreasy.ecommercek.dto.OrderDto;
import com.kryscreasy.ecommercek.dto.ProductDto;
import com.kryscreasy.ecommercek.dto.ShoppingDto;
import com.kryscreasy.ecommercek.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

//    @GetMapping("/current")
//    public String orderForm(Model model,@ModelAttribute("allProducts") ShoppingDto currentShopping) {
////        model.addAttribute("currentShopping", currentShopping);
//        List<ProductDto> currentCart;
//
//        ShoppingDto currentShopping    = currentShopping;
//        for (product:currentShopping) {
//            currentCart.add(product);
//        }
//
//        model.addAttribute("orderForm", new OrderDto());
//        return "orderForm";
//    }

    @PostMapping
    public String processOrder(@Valid @ModelAttribute("orderForm") OrderDto orderForm, BindingResult errors) {
        if (errors.hasErrors()) {
            return "orderForm";
        }
        log.info("Order submitted: " + orderForm);
        orderService.placeOrder(orderForm);
        return "redirect:/";
    }
}