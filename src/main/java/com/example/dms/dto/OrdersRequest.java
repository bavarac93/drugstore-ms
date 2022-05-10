package com.example.dms.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class OrdersRequest {
    @NotNull(message = "InventoryId cannot be null.")
    private Long inventoryId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateTimeOrdered;

    @NotBlank(message = "Instructions to customer are mandatory.")
    @NotEmpty(message = "Instructions to customer are mandatory.")
    @Size(min = 10, max = 200, message = "Instructions must be between 10 and 200 characters.")
    @Pattern(regexp = "[a-zA-Z\\d #%'*/<()>:`;,!&.?_]+", message = "Only letters, numbers and punctuation marks are allowed.")
    private String instructionsToCustomer;

    @NotNull(message = "CustomerId cannot be null.")
    private Long customerId;

    public Long getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(Long inventoryId) {
        this.inventoryId = inventoryId;
    }

    public LocalDateTime getDateTimeOrdered() {
        return dateTimeOrdered;
    }

    public void setDateTimeOrdered(LocalDateTime dateTimeOrdered) {
        this.dateTimeOrdered = dateTimeOrdered;
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
