package com.kryscreasy.ecommercek.service;

import com.kryscreasy.ecommercek.dto.CustomerDto;
import com.kryscreasy.ecommercek.entity.Customer;
import com.kryscreasy.ecommercek.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    private final PasswordEncoder passwordEncoder;
    private final CustomerRepository customerRepository;

    public CustomerService(PasswordEncoder passwordEncoder, CustomerRepository customerRepository) {
        this.passwordEncoder = passwordEncoder;
        this.customerRepository = customerRepository;
    }

    public void createCustomer(CustomerDto customerDto){
        Customer entity = new Customer();
        entity.setCustomerName(customerDto.getCustomerName());
        entity.setEmail(customerDto.getEmail());
        String encodedPassword = passwordEncoder.encode(customerDto.getPassword());
        entity.setPassword(encodedPassword);
        customerRepository.save(entity);
    }
    public List<CustomerDto> findAll() {
        return customerRepository.findAll().stream()
                .map(this::map)
                .collect(Collectors.toList());

    }
    public CustomerDto map(Customer customer){
        CustomerDto dto = new CustomerDto();
        dto.setCustomerName(customer.getCustomerName());
        dto.setPassword(customer.getPassword());
        dto.setEmail(customer.getEmail());
        return dto;
    }

}
