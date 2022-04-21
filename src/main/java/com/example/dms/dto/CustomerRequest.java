package com.example.dms.dto;

import javax.validation.constraints.*;

public class CustomerRequest extends CustomerRequestPhoneNumberPatch{
    @NotEmpty(message = "Name must be included in the brand.")
    @NotBlank(message = "Name must be included in the brand.")
    @Pattern(regexp = "[a-zA-Z]+", message = "First name can not contain special characters and numbers.")
    private String firstName;

    @NotEmpty(message = "Name must be included in the brand.")
    @NotBlank(message = "Name must be included in the brand.")
    @Pattern(regexp = "[a-zA-Z]+", message = "Last name can not contain special characters and numbers.")
    private String lastName;

    @NotBlank(message = "The email is obligatory.")
    @NotEmpty(message = "The email is obligatory.")
    @Email(flags = Pattern.Flag.CASE_INSENSITIVE, message = "Email must be a valid email address, e.g. example@mail.com")
    private String email;

    @NotBlank(message = "The drugs that the customer is allergic to must be written!")
    @NotEmpty(message = "The drugs that the customer is allergic to must be written!")
    @Size(min = 5, max = 300, message = "drugAllergicTo must be between 5 and 300 characters.")
    @Pattern(regexp = "[a-zA-Z\\d ]+")
    private String drugAllergicTo;

    public CustomerRequest() {
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
