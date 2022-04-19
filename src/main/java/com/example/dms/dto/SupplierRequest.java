package com.example.dms.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.*;
import java.time.LocalDateTime;

public class SupplierRequest {
    @NotEmpty(message = "Supplier must contain name.")
    @NotBlank(message = "Supplier must contain name.")
    @Pattern(regexp = "[a-zA-Z]+", message = "Supplier name can not contain special characters and numbers.")
    private String supplierName;

    @NotBlank(message = "The supplier must include the description.")
    @NotEmpty(message = "The supplier must include the description.")
    @Size(min = 10, max = 250, message = "Description must be between 10 and 250 characters.")
    @Pattern(regexp = "[a-zA-Z\\d#%'*/<()>:`;,!& .?_]+")
    private String supplierDesc;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @PastOrPresent(message = "The date must be in the past or present.")
    private LocalDateTime contractSigned;

    @Future(message = "The date must be in the future or present. Otherwise, the contract is expired.")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime contractExpires;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getSupplierDesc() {
        return supplierDesc;
    }

    public void setSupplierDesc(String supplierDesc) {
        this.supplierDesc = supplierDesc;
    }

    public LocalDateTime getContractSigned() {
        return contractSigned;
    }

    public void setContractSigned(LocalDateTime contractSigned) {
        this.contractSigned = contractSigned;
    }

    public LocalDateTime getContractExpires() {
        return contractExpires;
    }

    public void setContractExpires(LocalDateTime contractExpires) {
        this.contractExpires = contractExpires;
    }
}
