package com.kryscreasy.ecommercek.dto;

import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.CreditCardNumber;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Date;
import java.util.Map;

@Data
public class OrderDto {

//    private Map<Long, Integer> myCartIdAndAmount;

    private String firstname;
    private String lastname;
    //    @NotBlank(message = "Street is required")
    private String street;
    //    @NotBlank(message = "City is required")
    private String city;
    //    @NotBlank(message = "Zip code is required")
    private String zip;
    //    @CreditCardNumber(message = "Not a valid credit card number")
    private String ccNumber;
    //    @Pattern(regexp = "^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$", message = "Must be formatted MM/YY")
    private String ccExpiration;
    //    @Digits(integer = 3, fraction = 0, message = "Invalid CVV")
    private String ccCVV;
}