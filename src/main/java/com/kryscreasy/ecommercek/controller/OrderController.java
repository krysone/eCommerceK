package com.kryscreasy.ecommercek.controller;

import com.kryscreasy.ecommercek.dto.OrderDto;
import com.kryscreasy.ecommercek.dto.ProductDto;
import com.kryscreasy.ecommercek.dto.ShoppingDto;
import com.kryscreasy.ecommercek.service.OrderService;
import com.kryscreasy.ecommercek.service.ShoppingCartService;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/my-order")
public class OrderController {

    private final OrderService orderService;
    private final ShoppingCartService shoppingCartService;

    @GetMapping
    public String orderForm(Model model) {
        Map<ProductDto, Integer> productDtoIntegerMap = shoppingCartService.showMyCart();
        model.addAttribute("myCart", productDtoIntegerMap);
        Map<Long, Integer> myCartIdAndAmount = new HashMap<>();
        myCartIdAndAmount = shoppingCartService.showMyCartIdAndAmount();
        model.addAttribute("myCartIdAndAmount", myCartIdAndAmount);
        log.info("shoping Cart: " + myCartIdAndAmount.get(1L));
        model.addAttribute("orderForm", new OrderDto());
        return "orderForm";
    }

    @PostMapping
    public String processOrder(@Valid @ModelAttribute("orderForm") OrderDto orderForm, BindingResult errors) {
        if (errors.hasErrors()) {
            return "orderForm";
        }
        Map<Long, Integer> longIntegerMap = shoppingCartService.showMyCartIdAndAmount();
        log.info("Order submitted: " + orderForm);
        log.info("shoping Cart: " + longIntegerMap.get(1L));


        orderService.placeOrder(orderForm, longIntegerMap);
        return "redirect:/";
    }
}