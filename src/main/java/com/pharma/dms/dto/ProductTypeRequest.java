package com.pharma.dms.dto;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class ProductTypeRequest extends ProductTypeRequestPatch {
    @NotEmpty(message = "Product type must be included.")
    @NotBlank(message = "Product type must be included.")
    @Pattern(regexp = "[a-zA-Z ]+", message = "Product type can not contain special characters and numbers.")
    private String productType;

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

}
