package com.kryscreasy.ecommercek.controller;

import com.kryscreasy.ecommercek.dto.CustomerDto;
import com.kryscreasy.ecommercek.service.CustomerService;
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
@RequestMapping("/register")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping
    public String customers(Model model) {
        model.addAttribute("customerForm", new CustomerDto());
        return "register";
    }


    @PostMapping
    public String registerCustomer(@ModelAttribute CustomerDto customerForm) {
        log.info(customerForm.getCustomerName());
        customerService.createCustomer(customerForm);
        return "redirect:/register";
    }
}
