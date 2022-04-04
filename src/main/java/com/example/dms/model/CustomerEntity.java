package com.example.dms.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table (name = "customer")
public class CustomerEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private boolean isVerified;
    private Date dateJoined;
    private String creditCardNumber;
    private Date cardExpiry;
    private boolean isAllergic;
    private String drugAllergicTo;
    private  String createdBy;
    private LocalDateTime createdAt;

    public CustomerEntity() {

    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public CustomerEntity(Long id, String firstName, String lastName, String phoneNumber, String email, boolean isVerified, Date dateJoined, String creditCardNumber, Date cardExpiry, boolean isAllergic) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.isVerified = isVerified;
        this.dateJoined = dateJoined;
        this.creditCardNumber = creditCardNumber;
        this.cardExpiry = cardExpiry;
        this.isAllergic = isAllergic;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public boolean isVerified() {
        return isVerified;
    }

    public void setVerified(boolean isVerified) {
        isVerified = isVerified;
    }

    public Date getDateJoined() {
        return dateJoined;
    }

    public void setDateJoined(Date dateJoined) {
        this.dateJoined = dateJoined;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public Date getCardExpiry() {
        return cardExpiry;
    }

    public void setCardExpiry(Date cardExpiry) {
        this.cardExpiry = cardExpiry;
    }

    public boolean isAllergic() {
        return isAllergic;
    }

    public void setAllergic(boolean allergic) {
        isAllergic = allergic;
    }

    public String getDrugAllergicTo() {
        return drugAllergicTo;
    }

    public void setDrugAllergicTo(String drugAllergicTo) {
        this.drugAllergicTo = drugAllergicTo;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CustomerEntity{");
        sb.append("id=").append(id);
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", phoneNumber='").append(phoneNumber).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", isVerified=").append(isVerified);
        sb.append(", dateJoined=").append(dateJoined);
        sb.append(", creditCardNumber='").append(creditCardNumber).append('\'');
        sb.append(", cardExpiry=").append(cardExpiry);
        sb.append(", isAllergic=").append(isAllergic);
        sb.append(", drugAllergicTo='").append(drugAllergicTo).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
