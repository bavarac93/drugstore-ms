package com.pharma.dms.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class BrandRequestPatch {
    @NotBlank(message = "The brand must include the description.")
    @NotEmpty(message = "The brand must include the description.")
    @Size(min = 10, max = 200, message = "Description must be between 10 and 200 characters.")
    @Pattern(regexp = "[a-zA-Z\\d #%'*/<()>:`;,!&.?_]+", message = "Only letters, numbers and punctuation marks are allowed.")
    private String brandDesc;

    public String getBrandDesc() {
        return brandDesc;
    }

    public void setBrandDesc(String brandDesc) {
        this.brandDesc = brandDesc;
    }
}
