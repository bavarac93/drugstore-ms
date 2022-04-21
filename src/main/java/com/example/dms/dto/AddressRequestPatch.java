package com.example.dms.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class AddressRequestPatch {

    @NotEmpty(message = "Building number must be included in the address.")
    @NotBlank(message = "Building number must be included in the address.")
    @Size(min = 1, max = 5, message = "Building number must be between 1 and 5 characters.")
    @Pattern(regexp = "[a-zA-Z\\d ]+", message = "Cannot contain special characters!")
    private String buildingNumber;

    @NotEmpty(message = "Street is a required field.")
    @NotBlank(message = "Street is a required field.")
    @Size(min = 5, max = 50, message = "Street must be between 5 and 50 characters.")
    @Pattern(regexp = "[a-zA-Z ]+", message = "Cannot contain special characters and numbers!")
    private String street;

    public String getBuildingNumber() {
        return buildingNumber;
    }

    public String setBuildingNumber(String buildingNumber) {
        this.buildingNumber = buildingNumber;
        return buildingNumber;
    }

    public String getStreet() {
        return street;
    }

    public String setStreet(String street) {
        this.street = street;
        return street;
    }
}
