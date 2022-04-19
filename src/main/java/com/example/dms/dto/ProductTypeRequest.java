package com.example.dms.dto;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class ProductTypeRequest {

    @NotEmpty(message = "Product type must be included.")
    @NotBlank(message = "Product type must be included.")
    @Pattern(regexp = "[a-zA-Z]+", message = "Product type can not contain special characters and numbers.")
    private String productType;

    @NotBlank(message = "The product must have the description.")
    @NotEmpty(message = "The product must have the description.")
    @Size(min = 10, max = 250, message = "Description must be between 10 and 250 characters.")
    @Pattern(regexp = "[a-zA-Z\\d#%'*/<()>:`;,!& .?_]+")
    private String productTypeDesc;


    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getProductTypeDesc() {
        return productTypeDesc;
    }

    public void setProductTypeDesc(String productTypeDesc) {
        this.productTypeDesc = productTypeDesc;
    }

}
