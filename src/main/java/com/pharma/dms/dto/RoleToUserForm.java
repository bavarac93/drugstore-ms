package com.pharma.dms.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class RoleToUserForm {
    @NotBlank(message = "Username is mandatory.")
    @NotEmpty(message = "Username is mandatory.")
    @Size(min = 3, max = 25, message = "Username must be between 5 and 25 characters.")
    @Pattern(regexp = "[a-zA-Z\\d]+", message = "Username can only contain letters and numbers.")
    private String username;

    @NotEmpty(message = "Role must contain name.")
    @NotBlank(message = "Role must contain name.")
    @Size(min = 4, max = 15, message = "Role must be between 4 and 15 characters.")
    @Pattern(regexp = "[a-zA-Z ]+", message = "Role can not contain special characters and numbers.")
    private String roleName;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
