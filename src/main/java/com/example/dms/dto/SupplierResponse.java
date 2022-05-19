package com.example.dms.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class SupplierResponse {
    private Long id;
    private String supplierName;
    private String supplierDesc;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate contractSigned;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate contractExpires;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
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

    public LocalDate getContractSigned() {
        return contractSigned;
    }

    public void setContractSigned(LocalDate contractSigned) {
        this.contractSigned = contractSigned;
    }

    public LocalDate getContractExpires() {
        return contractExpires;
    }

    public void setContractExpires(LocalDate contractExpires) {
        this.contractExpires = contractExpires;
    }
}
