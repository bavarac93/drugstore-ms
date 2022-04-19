package com.example.dms.dto;


import javax.validation.constraints.*;
import java.time.LocalDateTime;

public class InventoryRequest {
    @NotEmpty(message = "Item name must be included in the request.")
    @NotBlank(message = "Item name must be included in the request.")
    @Pattern(regexp = "[a-zA-Z]+", message = "Item name can not contain special characters and numbers.")
    private String itemName;

    @NotBlank(message = "The item must have the description.")
    @NotEmpty(message = "The item must have the description.")
    @Size(min = 10, max = 250, message = "Description must be between 10 and 250 characters.")
    @Pattern(regexp = "[a-zA-Z\\d#%'*/<()>:`;,!& .?_]+")
    private String description;

    private Long price;
    private String sku;
    private Long quantity;
    private Long sold;
    private LocalDateTime expiryDate;

    @NotNull
    private Long brandId;
    @NotNull
    private Long productTypeId;
    @NotNull
    private Long supplierId;

    public Long getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(Long productTypeId) {
        this.productTypeId = productTypeId;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public LocalDateTime getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDateTime expiryDate) {
        this.expiryDate = expiryDate;
    }

}
