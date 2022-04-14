package com.example.dms.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table (name = "product_type")
public class ProductTypeEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    private String productType;
    private String productTypeDesc;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private String createdBy;
    private String modifiedBy;

    public ProductTypeEntity() {
    }


}
