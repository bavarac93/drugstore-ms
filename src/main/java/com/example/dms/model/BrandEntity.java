package com.example.dms.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "brand")
public class BrandEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String brandName;
    private String brandDesc;
    private LocalDateTime createdAt;
    private String createdBy;
    private String phoneNumber;
    private String email;
    private String website;
    private LocalDateTime modifiedAt;
    private String modifiedBy;

    public BrandEntity() {
    }

    public BrandEntity(Long id, String brandName, String brandDesc, LocalDateTime createdAt, String createdBy, String phoneNumber, String email, String website) {
        this.id = id;
        this.brandName = brandName;
        this.brandDesc = brandDesc;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.website = website;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(LocalDateTime modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }


}




