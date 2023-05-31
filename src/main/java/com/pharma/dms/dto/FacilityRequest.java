package com.pharma.dms.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class FacilityRequest {
    public static final String WEBSITE_REGEX = "(https?:\\/\\/)?(www\\.)[-a-zA-Z0-9@:%._\\+~#=]{2,256}\\.[a-z]{2,4}\\b([-a-zA-Z0-9@:%_\\+.~#?&//=]*)|(https?:\\/\\/)?(www\\.)?(?!ww)[-a-zA-Z0-9@:%._\\+~#=]{2,256}\\.[a-z]{2,4}\\b([-a-zA-Z0-9@:%_\\+.~#?&//=]*)";

    @NotEmpty(message = "Facility name must be included in the request.")
    @NotBlank(message = "Facility name must be included in the request.")
    @Pattern(regexp = "[a-zA-Z ]+", message = "Facility name can not contain special characters and numbers.")
    private String facilityName;
    @NotBlank(message = "A phone number is required.")
    @NotEmpty(message = "A phone number is required.")
    @Size(min = 9, max = 12, message = "Phone number must be between 9 and 12 characters.")
    @Pattern(regexp = "[ +\\d]+", message = "Only numbers with country code are allowed.")
    private String phoneNumber;
    @NotBlank(message = "The email is obligatory.")
    @NotEmpty(message = "The email is obligatory.")
    @Email(
            regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}",
            flags = Pattern.Flag.CASE_INSENSITIVE,
            message = "A correct format of the email must be used, e.g. example@mail.com"
    )
    private String email;
    @NotBlank(message = "The facility must include the website.")
    @NotEmpty(message = "The facility must include the website.")
    @Pattern(regexp = WEBSITE_REGEX, message = "A default website format is: http://www.example.com/ ")
    private String website;
    @NotNull(message = "AddressId cannot be null.")
    private Long addressId;
    @NotNull(message = "InventoryId cannot be null.")
    private Long inventoryId;
    @NotNull(message = "OrdersId cannot be null.")
    private Long ordersId;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOpened;

    public String getFacilityName() {
        return facilityName;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public Long getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(Long inventoryId) {
        this.inventoryId = inventoryId;
    }

    public Long getOrdersId() {
        return ordersId;
    }

    public void setOrdersId(Long ordersId) {
        this.ordersId = ordersId;
    }

    public LocalDate getDateOpened() {
        return dateOpened;
    }

    public void setDateOpened(LocalDate dateOpened) {
        this.dateOpened = dateOpened;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}
