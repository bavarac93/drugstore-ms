package com.example.dms.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table (name = "product_type")
public class ProductTypeEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long productTypeId;
    private String name;

    @ManyToOne
    @JoinColumn(name = "medication_id")
    private MedicationEntity medicationEntity;

    @ManyToOne
    @JoinColumn(name = "medical_supplies_id")
    private MedicalSuppliesEntity medicalSuppliesEntity;

    @ManyToOne
    @JoinColumn(name = "beauty_product_id")
    private BeautyProductEntity beautyProductEntity;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private String createdBy;
    private String modifiedBy;

    public ProductTypeEntity() {
    }

    public ProductTypeEntity(Long productTypeId, String name, MedicationEntity medicationEntity, MedicalSuppliesEntity medicalSuppliesEntity, BeautyProductEntity beautyProductEntity, LocalDateTime createdAt, String createdBy) {
        this.productTypeId = productTypeId;
        this.name = name;
        this.medicationEntity = medicationEntity;
        this.medicalSuppliesEntity = medicalSuppliesEntity;
        this.beautyProductEntity = beautyProductEntity;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
    }

    public BeautyProductEntity getBeautyProductEntity() {
        return beautyProductEntity;
    }

    public MedicalSuppliesEntity getMedicalSuppliesEntity() {
        return medicalSuppliesEntity;
    }

    public MedicationEntity getMedicationEntity() {
        return medicationEntity;
    }

    public Long getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(Long productTypeId) {
        this.productTypeId = productTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMedicationEntity(MedicationEntity medicationEntity) {
        this.medicationEntity = medicationEntity;
    }

    public void setMedicalSuppliesEntity(MedicalSuppliesEntity medicalSuppliesEntity) {
        this.medicalSuppliesEntity = medicalSuppliesEntity;
    }

    public void setBeautyProductEntity(BeautyProductEntity beautyProductEntity) {
        this.beautyProductEntity = beautyProductEntity;
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ProductTypeEntity{");
        sb.append("productTypeId=").append(productTypeId);
        sb.append(", name='").append(name).append('\'');
        sb.append(", medicationEntity=").append(medicationEntity);
        sb.append(", medicalSuppliesEntity=").append(medicalSuppliesEntity);
        sb.append(", beautyProductEntity=").append(beautyProductEntity);
        sb.append(", createdAt=").append(createdAt);
        sb.append(", modifiedAt=").append(modifiedAt);
        sb.append(", createdBy='").append(createdBy).append('\'');
        sb.append(", modifiedBy='").append(modifiedBy).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
