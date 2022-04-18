package com.example.dms.dto;

import java.time.LocalDateTime;

public class SupplierResponse {
    private Long id;
    private String supplierName;
    private String supplierDesc;
    private LocalDateTime contractSigned;
    private LocalDateTime contractExpires;
    private LocalDateTime createdAt;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

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
