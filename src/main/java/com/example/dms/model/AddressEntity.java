package com.example.dms.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table (name = "address")
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String buildingNumber;
    private String street;
    private String city;
    private String postcode;
    private String country;
    private LocalDateTime modifiedAt;
    private String modifiedBy;
    private LocalDateTime createdAt;
    private String createdBy;


    public AddressEntity( ) {
    }

    public AddressEntity(String buildingNumber, String street, String city, String postcode, String country, LocalDateTime createdAt) {
        this.buildingNumber = buildingNumber;
        this.street = street;
        this.city = city;
        this.postcode = postcode;
        this.country = country;
        this.createdAt = createdAt;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(String buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AddressEntity{");
        sb.append("id=").append(id);
        sb.append(", buildingNumber='").append(buildingNumber).append('\'');
        sb.append(", street='").append(street).append('\'');
        sb.append(", city='").append(city).append('\'');
        sb.append(", postcode=").append(postcode);
        sb.append(", country='").append(country).append('\'');
        sb.append(", modifiedAt=").append(modifiedAt);
        sb.append(", modifiedBy='").append(modifiedBy).append('\'');
        sb.append(", createdAt=").append(createdAt);
        sb.append(", createdBy='").append(createdBy).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
