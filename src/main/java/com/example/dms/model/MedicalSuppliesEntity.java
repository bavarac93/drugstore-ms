package com.example.dms.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table (name = "medical_supplies")
public class MedicalSuppliesEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String sku;
    private Long description;
    private String expiryDate;
    private LocalDateTime createdAt;
    private LocalDateTime createdBy;
    private LocalDateTime modifiedAt;
    private LocalDateTime modifiedBy;

    public MedicalSuppliesEntity(Long id, String name, String sku, Long description, String expiryDate, LocalDateTime createdAt, LocalDateTime createdBy) {
        this.id = id;
        this.name = name;
        this.sku = sku;
        this.description = description;
        this.expiryDate = expiryDate;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public Long getDescription() {
        return description;
    }

    public void setDescription(Long description) {
        this.description = description;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(LocalDateTime createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(LocalDateTime modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public LocalDateTime getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(LocalDateTime modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MedicalSuppliesEntity{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", sku='").append(sku).append('\'');
        sb.append(", description=").append(description);
        sb.append(", expiryDate='").append(expiryDate).append('\'');
        sb.append(", createdAt=").append(createdAt);
        sb.append(", createdBy=").append(createdBy);
        sb.append(", modifiedAt=").append(modifiedAt);
        sb.append(", modifiedBy=").append(modifiedBy);
        sb.append('}');
        return sb.toString();
    }
}
