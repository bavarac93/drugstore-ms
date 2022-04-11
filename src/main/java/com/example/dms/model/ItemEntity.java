package com.example.dms.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table (name = "item")
public class ItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long itemId;
    @OneToMany
    @JoinColumn(name = "brand_id")
    private BrandEntity brandId;

    @OneToMany
    @JoinColumn(name = "supplier_id")
    private SupplierEntity supplierEntity;

    @OneToMany
    @JoinColumn(name = "product_id")
    private ProductTypeEntity productType;
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

    public BrandEntity getBrandId() {
        return brandId;
    }

    public ItemEntity() {
    }

}

