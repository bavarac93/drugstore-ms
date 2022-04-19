package com.example.dms.dto;


import javax.validation.constraints.*;

public class AddressRequest {

    @NotEmpty(message = "Building number must be included in the address.")
    @NotBlank(message = "Building number must be included in the address.")
    @Size(min = 1, max = 5, message = "Building number must be between 1 and 5 characters.")
    private String buildingNumber;

    @NotEmpty(message = "Street is a required field in the address.")
    @NotBlank(message = "Street is a required field in the address.")
    @Size(min = 5, max = 50, message = "Street must be between 5 and 50 characters.")
    private String street;

    @NotBlank(message = "City is a mandatory field.")
    @NotEmpty(message = "City is a mandatory field.")
    @Size(min = 1, max = 25, message = "City must be between 1 and 25 characters.")
    private String city;

    @NotBlank(message = "The address must include the postcode.")
    @NotEmpty(message = "The address must include the postcode.")
    @Min(value = 1000, message = "The postcode cannot be under 1000")
    @Max(value = 100_000, message = "The postcode cannot be over 100 000")
    private String postcode;

    @NotBlank(message = "Country is obligatory!")
    @NotNull(message = "Country is obligatory!")
    @Size(min = 4, max = 60, message = "Country must be between 4 and 60 characters.")
    private String country;

    public AddressRequest() {
    }

    public String getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(String buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
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
