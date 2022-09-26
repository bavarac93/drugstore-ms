package com.example.dms.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;

public class InventoryRequest extends InventoryRequestPatch {
    @NotEmpty(message = "Item name must be included in the request.")
    @NotBlank(message = "Item name must be included in the request.")
    @Pattern(regexp = "[a-zA-Z ]+", message = "Item name can not contain special characters and numbers.")
    private String itemName;

    @Min(value = 1, message = "Minimum price is 1.")
    @Max(value = 500, message = "Maximum price is 500")
    private Long price;

    @NotBlank(message = "Stock keeping unit (SKU) is mandatory.")
    @NotEmpty(message = "Stock keeping unit (SKU) is mandatory.")
    @Size(min = 10, max = 10, message = "SKU must be 10 characters long.")
    @Pattern(regexp = "[a-zA-Z\\d]+", message = "SKU can only contain letters and numbers.")
    private String sku;

    @Min(value = 1, message = "Minimum quantity is 1.")
    @Max(value = 1_000, message = "Maximum quantity is 1 000")
    private Long quantity;

    @Max(value = 1_000, message = "Maximum number of sold items is 1 000")
    private Long sold;

    @FutureOrPresent(message = "The expiry date must be valid. Otherwise, the item cannot be used.")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate expiryDate;

    @NotNull(message = "BrandId cannot be null.")
    private Long brandId;
    @NotNull(message = "ProductTypeId cannot be null.")
    private Long productTypeId;
    @NotNull(message = "SupplierId cannot be null.")
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

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }
}
