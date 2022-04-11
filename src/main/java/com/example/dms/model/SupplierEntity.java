package com.example.dms.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table (name = "supplier")
public class SupplierEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    private String supplierName;
    @ManyToOne
    @JoinColumn(name = "product_type_id")
    private ProductTypeEntity productTypeEntity;
    @ManyToOne
    @JoinColumn(name = "brand_id")
    private BrandEntity brandEntity;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private String createdBy;
    private String modifiedBy;

    public SupplierEntity() {
    }

    public BrandEntity getBrandEntity() {
        return brandEntity;
    }

    public ProductTypeEntity getProductTypeEntity() {
        return productTypeEntity;
    }

    public SupplierEntity(Long id, String supplierName, ProductTypeEntity productTypeEntity, BrandEntity brandEntity, LocalDateTime createdAt, String createdBy) {
        this.id = id;
        this.supplierName = supplierName;
        this.productTypeEntity = productTypeEntity;
        this.brandEntity = brandEntity;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
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

    public void setProductTypeEntity(ProductTypeEntity productTypeEntity) {
        this.productTypeEntity = productTypeEntity;
    }

    public void setBrandEntity(BrandEntity brandEntity) {
        this.brandEntity = brandEntity;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(LocalDateTime modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }
}
