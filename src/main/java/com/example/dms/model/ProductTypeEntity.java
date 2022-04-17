package com.example.dms.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table (name = "product_type")
public class ProductTypeEntity extends Audit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String productType;
    private String productTypeDesc;

    public ProductTypeEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getProductTypeDesc() {
        return productTypeDesc;
    }

    public void setProductTypeDesc(String productTypeDesc) {
        this.productTypeDesc = productTypeDesc;
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
        final StringBuilder sb = new StringBuilder("ProductTypeEntity{");
        sb.append("id=").append(id);
        sb.append(", productType='").append(productType).append('\'');
        sb.append(", productTypeDesc='").append(productTypeDesc).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
