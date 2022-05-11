package com.example.dms.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class RoleRequest {
    @NotEmpty(message = "Role must contain name.")
    @NotBlank(message = "Role must contain name.")
    @Size(min = 4, max = 15, message = "Role must be between 4 and 15 characters.")
    @Pattern(regexp = "[a-zA-Z ]+", message = "Role can not contain special characters and numbers.")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
