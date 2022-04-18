package com.example.dms.dto;

import java.time.LocalDateTime;

public class SupplierRequest {
    private String supplierName;
    private String supplierDesc;
    private LocalDateTime contractSigned;
    private LocalDateTime contractExpires;

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
