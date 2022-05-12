package com.example.dms.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class CustomerRequest extends CustomerRequestPhoneNumberPatch {
    @NotEmpty(message = "Name must be included in the brand.")
    @NotBlank(message = "Name must be included in the brand.")
    @Pattern(regexp = "[a-zA-Z]+", message = "First name can not contain special characters and numbers.")
    private String firstName;

    @NotEmpty(message = "Name must be included in the brand.")
    @NotBlank(message = "Name must be included in the brand.")
    @Pattern(regexp = "[a-zA-Z]+", message = "Last name can not contain special characters and numbers.")
    private String lastName;

    @Email(flags = Pattern.Flag.CASE_INSENSITIVE, message = "Email must be a valid email address, e.g. example@mail.com")
    private String email;

    @NotBlank(message = "The drugs that the customer is allergic to must be written!")
    @NotEmpty(message = "The drugs that the customer is allergic to must be written!")
    @Size(min = 5, max = 300, message = "drugAllergicTo must be between 5 and 300 characters.")
    @Pattern(regexp = "[A-Z\\d ]+", message = "Only uppercase words and numbers are accepted.")
    private String drugAllergicTo;

    @NotNull(message = "AddressId cannot be null.")
    private Long addressId;

    public CustomerRequest() {
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public String getDrugAllergicTo() {
        return drugAllergicTo;
    }

    public void setDrugAllergicTo(String drugAllergicTo) {
        this.drugAllergicTo = drugAllergicTo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
