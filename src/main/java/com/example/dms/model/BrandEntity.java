package com.example.dms.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table (name = "brand")
public class BrandEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long brandId;
    private String brandName;
    private String brandDesc;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    @ManyToOne
    @JoinColumn(name = "product_type_id")
    private ProductTypeEntity productType;

    @ManyToOne
    @JoinColumn(name = "supplier_entity_id")
    private SupplierEntity supplierEntity;

    public BrandEntity() {
    }

    public BrandEntity(Long brandId, String brandName, String brandDesc, ProductTypeEntity productType, SupplierEntity supplierEntity, LocalDateTime createdAt) {
        this.brandId = brandId;
        this.brandName = brandName;
        this.brandDesc = brandDesc;
        this.productType = productType;
        this.supplierEntity = supplierEntity;
        this.createdAt = createdAt;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getBrandDesc() {
        return brandDesc;
    }

    public void setBrandDesc(String brandDesc) {
        this.brandDesc = brandDesc;
    }

    public ProductTypeEntity getProductType() {
        return productType;
    }

    public void setProductType(ProductTypeEntity productType) {
        this.productType = productType;
    }

    public SupplierEntity getSupplierEntity() {
        return supplierEntity;
    }

    public void setSupplierEntity(SupplierEntity supplierEntity) {
        this.supplierEntity = supplierEntity;
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BrandEntity{");
        sb.append("brandId=").append(brandId);
        sb.append(", brandName='").append(brandName).append('\'');
        sb.append(", brandDesc='").append(brandDesc).append('\'');
        sb.append(", productType=").append(productType);
        sb.append(", supplierEntity=").append(supplierEntity);
        sb.append(", createdAt=").append(createdAt);
        sb.append(", modifiedAt=").append(modifiedAt);
        sb.append('}');
        return sb.toString();
    }
}
