package com.kryscreasy.ecommercek.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class CustomerDto {

//    @NotBlank
//    @Min(2)
//    @Max(255)
    private String customerName;

//    @NotBlank
//    @Min(4)
//    @Max(255)
//    @Email
    private String email;

//    @NotBlank
//    @Min(2)
//    @Max(255)
    private String password;


    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
