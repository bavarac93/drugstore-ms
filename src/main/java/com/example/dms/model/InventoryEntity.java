package com.example.dms.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table (name = "inventory")
public class InventoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String itemName;
    private Long price;
    private String sku;
    private Long quantity;
    private Long sold;
    private Long available;
    private Long description;
    private String expiryDate;
    private LocalDateTime createdAt;
    private LocalDateTime createdBy;
    private LocalDateTime modifiedAt;
    private LocalDateTime modifiedBy;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private BrandEntity brandEntity;

//    @OneToMany
//    @JoinColumn(name = "supplier_id")
//    private SupplierEntity supplierEntity;
//
//    @OneToMany
//    @JoinColumn(name = "product_id")
//    private ProductTypeEntity productType;


    public InventoryEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Long getSold() {
        return sold;
    }

    public void setSold(Long sold) {
        this.sold = sold;
    }

    public Long getAvailable() {
        return available;
    }

    public void setAvailable(Long available) {
        this.available = available;
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

    public BrandEntity getBrandEntity() {
        return brandEntity;
    }

    public void setBrandEntity(BrandEntity brandEntity) {
        this.brandEntity = brandEntity;
    }
}

