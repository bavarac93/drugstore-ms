package com.pharma.dms.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class InventoryRequestPatch {
    @NotBlank(message = "The item must have the description.")
    @NotEmpty(message = "The item must have the description.")
    @Size(min = 10, max = 250, message = "Description must be between 10 and 250 characters.")
    @Pattern(regexp = "[a-zA-Z\\d #%'*/<()>:`;,!&.?_]+", message = "Only letters, numbers and punctuation marks are allowed.")
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
