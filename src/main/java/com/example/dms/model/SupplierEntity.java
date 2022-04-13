package com.example.dms.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table (name = "supplier")
public class SupplierEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String supplierName;
    //    @ManyToOne
//    @JoinColumn(name = "product_type_id")
//    private ProductTypeEntity productTypeEntity;
//    @ManyToOne
//    @JoinColumn(name = "brand_id")
//    private BrandEntity brandEntity;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private String createdBy;
    private String modifiedBy;

    public SupplierEntity() {
    }

}
