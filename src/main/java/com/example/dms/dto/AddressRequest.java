package com.example.dms.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class AddressRequest extends AddressRequestPatch {

    @NotBlank(message = "City is a mandatory field.")
    @NotEmpty(message = "City is a mandatory field.")
    @Size(min = 1, max = 25, message = "City must be between 1 and 25 characters.")
    @Pattern(regexp = "[a-zA-Z ]+", message = "Cannot contain special characters and numbers!")
    private String city;

    @NotBlank(message = "The address must include the postcode.")
    @NotEmpty(message = "The address must include the postcode.")
    @Min(value = 1000, message = "The postcode cannot be under 1000")
    @Max(value = 100_000, message = "The postcode cannot be over 100 000")
    @Pattern(regexp = "\\d+", message = "Cannot contain special characters and letters!")
    private String postcode;

    @NotBlank(message = "Country is obligatory!")
    @NotNull(message = "Country is obligatory!")
    @Size(min = 4, max = 60, message = "Country must be between 4 and 60 characters.")
    @Pattern(regexp = "[a-zA-Z ]+", message = "Cannot contain special characters and numbers!")
    private String country;

    public AddressRequest() {
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
