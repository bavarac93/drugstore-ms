package com.example.dms.dto;


import javax.validation.constraints.*;

public class BrandRequest {

    public static final String WEBSITE_REGEX = "(https?:\\/\\/)?(www\\.)[-a-zA-Z0-9@:%._\\+~#=]{2,256}\\.[a-z]{2,4}\\b([-a-zA-Z0-9@:%_\\+.~#?&//=]*)|(https?:\\/\\/)?(www\\.)?(?!ww)[-a-zA-Z0-9@:%._\\+~#=]{2,256}\\.[a-z]{2,4}\\b([-a-zA-Z0-9@:%_\\+.~#?&//=]*)";

    @NotEmpty(message = "Name must be included in the brand.")
    @NotBlank(message = "Name must be included in the brand.")
    @Pattern(regexp = "[a-zA-Z]+", message = "Brand name can not contain special characters and numbers.")
    private String brandName;

    @NotBlank(message = "The brand must include the description.")
    @NotEmpty(message = "The brand must include the description.")
    @Size(min = 10, max = 200, message = "Description must be between 10 and 200 characters.")
    @Pattern(regexp = "[a-zA-Z\\d#%'*/<()>:`;,!& .?_]+", message = "Only letters, numbers and punctuation marks are allowed.")
    private String brandDesc;

    @NotBlank(message = "A phone number is required.")
    @NotEmpty(message = "A phone number is required.")
    @Size(min = 9, max = 12, message = "Phone number must be between 9 and 12 characters.")
    @Pattern(regexp = "[\\d]+", message = "Only numbers without spaces are allowed.")
    private String phoneNumber;

    @NotBlank(message = "The email is obligatory.")
    @NotEmpty(message = "The email is obligatory.")
    @Email(
            regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}",
            flags = Pattern.Flag.CASE_INSENSITIVE,
            message = "A correct format of the email must be used, e.g. example@mail.com"
    )
    private String email;

    @NotBlank(message = "The brand must include the website.")
    @NotEmpty(message = "The brand must include the website.")
    @Pattern(regexp = WEBSITE_REGEX, message = "A default website format is: http://www.example.com/index.html ")
    private String website;

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getBrandDesc() {
        return brandDesc;
    }

    public void setBrandDesc(String brandDesc) {
        this.brandDesc = brandDesc;
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
