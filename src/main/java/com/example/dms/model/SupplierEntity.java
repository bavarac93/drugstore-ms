package com.example.dms.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "supplier")
public class SupplierEntity extends AuditSuperclass {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String supplierName;
    private String supplierDesc;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate contractSigned;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate contractExpires;

    public SupplierEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public String getCreatedBy() {
        return super.getCreatedBy();
    }

    @Override
    public void setCreatedBy(String createdBy) {
        super.setCreatedBy(createdBy);
    }

    @Override
    public LocalDateTime getCreatedAt() {
        return super.getCreatedAt();
    }

    @Override
    public void setCreatedAt(LocalDateTime createdAt) {
        super.setCreatedAt(createdAt);
    }

    @Override
    public LocalDateTime getModifiedAt() {
        return super.getModifiedAt();
    }

    @Override
    public void setModifiedAt(LocalDateTime modifiedAt) {
        super.setModifiedAt(modifiedAt);
    }

    @Override
    public String getModifiedBy() {
        return super.getModifiedBy();
    }

    @Override
    public void setModifiedBy(String modifiedBy) {
        super.setModifiedBy(modifiedBy);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SupplierEntity{");
        sb.append("id=").append(id);
        sb.append(", supplierName='").append(supplierName).append('\'');
        sb.append(", supplierDesc='").append(supplierDesc).append('\'');
        sb.append(", contractSigned=").append(contractSigned);
        sb.append(", contractExpires=").append(contractExpires);
        sb.append('}');
        return sb.toString();
    }
}
