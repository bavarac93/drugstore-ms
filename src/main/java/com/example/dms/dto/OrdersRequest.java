package com.example.dms.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.*;
import java.time.LocalDateTime;

public class OrdersRequest {
    @NotNull(message = "InventoryId cannot be null.")
    private Long inventoryId;

    @FutureOrPresent(message = "Date of order must be valid.")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateOrdered;

    @NotBlank(message = "Instructions to customer are mandatory.")
    @NotEmpty(message = "Instructions to customer are mandatory.")
    @Size(min = 10, max = 10, message = "SKU must be 10 characters long.")
    @Pattern(regexp = "[a-zA-Z\\d]+", message = "SKU can only contain letters and numbers.")
    private String instructionsToCustomer;

    @NotNull(message = "CustomerId cannot be null.")
    private Long customerId;

    public Long getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(Long inventoryId) {
        this.inventoryId = inventoryId;
    }

    public LocalDateTime getDateOrdered() {
        return dateOrdered;
    }

    public void setDateOrdered(LocalDateTime dateOrdered) {
        this.dateOrdered = dateOrdered;
    }

    public String getInstructionsToCustomer() {
        return instructionsToCustomer;
    }

    public void setInstructionsToCustomer(String instructionsToCustomer) {
        this.instructionsToCustomer = instructionsToCustomer;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
}
