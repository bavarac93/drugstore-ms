package com.example.dms.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;

public class SupplierRequest extends SupplierRequestPatch {
    @NotEmpty(message = "Supplier must contain name.")
    @NotBlank(message = "Supplier must contain name.")
    @Pattern(regexp = "[a-zA-Z ]+", message = "Supplier name can not contain special characters and numbers.")
    private String supplierName;

    @NotBlank(message = "The supplier must include the description.")
    @NotEmpty(message = "The supplier must include the description.")
    @Size(min = 10, max = 250, message = "Description must be between 10 and 250 characters.")
    @Pattern(regexp = "[a-zA-Z\\d #%'*/<()>:`;,!&.?_]+", message = "Only letters, numbers and punctuation marks are allowed.")
    private String supplierDesc;

    @JsonFormat(pattern="yyyy-MM-dd")
    @PastOrPresent(message = "The date must be in the past or present.")
    private LocalDate contractSigned;

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierDesc() {
        return supplierDesc;
    }

    public void setSupplierDesc(String supplierDesc) {
        this.supplierDesc = supplierDesc;
    }

    public LocalDate getContractSigned() {
        return contractSigned;
    }

    public void setContractSigned(LocalDate contractSigned) {
        this.contractSigned = contractSigned;
    }

}
