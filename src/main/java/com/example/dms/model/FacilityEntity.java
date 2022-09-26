package com.example.dms.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "facility")
public class FacilityEntity extends AuditSuperclass {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String facilityName;
    private String phoneNumber;
    private String email;
    private String website;
    @OneToOne
    @JoinColumn(name = "address_id")
    private AddressEntity addressEntity;
    @OneToOne
    @JoinColumn(name = "inventory_id")
    private InventoryEntity inventoryEntity;
    @OneToOne
    @JoinColumn(name = "orders_id")
    private OrdersEntity ordersEntity;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOpened;

    public FacilityEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFacilityName() {
        return facilityName;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
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

    public AddressEntity getAddressEntity() {
        return addressEntity;
    }

    public void setAddressEntity(AddressEntity addressEntity) {
        this.addressEntity = addressEntity;
    }

    public InventoryEntity getInventoryEntity() {
        return inventoryEntity;
    }

    public void setInventoryEntity(InventoryEntity inventoryEntity) {
        this.inventoryEntity = inventoryEntity;
    }

    public OrdersEntity getOrdersEntity() {
        return ordersEntity;
    }

    public void setOrdersEntity(OrdersEntity ordersEntity) {
        this.ordersEntity = ordersEntity;
    }

    public LocalDate getDateOpened() {
        return dateOpened;
    }

    public void setDateOpened(LocalDate dateOpened) {
        this.dateOpened = dateOpened;
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
        final StringBuilder sb = new StringBuilder("FacilityEntity{");
        sb.append("id=").append(id);
        sb.append(", facilityName='").append(facilityName).append('\'');
        sb.append(", phoneNumber='").append(phoneNumber).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", website='").append(website).append('\'');
        sb.append(", addressEntity=").append(addressEntity);
        sb.append(", inventoryEntity=").append(inventoryEntity);
        sb.append(", ordersEntity=").append(ordersEntity);
        sb.append(", dateOpened=").append(dateOpened);
        sb.append('}');
        return sb.toString();
    }
}
