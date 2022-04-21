package com.example.dms.dto;

import javax.validation.constraints.*;

public class CustomerRequestPhoneNumberPatch {
    @NotBlank(message = "A phone number is required.")
    @NotEmpty(message = "A phone number is required.")
    @Size(min = 9, max = 15, message = "Phone number must be between 9 and 12 characters.")
    @Pattern(regexp = "[\\d]+", message = "Only numbers without spaces are allowed.")
    private String phoneNumber;


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
