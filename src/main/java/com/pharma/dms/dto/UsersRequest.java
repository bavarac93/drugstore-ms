package com.pharma.dms.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UsersRequest {
    @NotEmpty(message = "Name must contain name.")
    @NotBlank(message = "Name must contain name.")
    @Size(min = 3, max = 25, message = "Role must be between 3 and 25 characters.")
    @Pattern(regexp = "[a-zA-Z ]+", message = "Name can not contain special characters and numbers.")
    private String name;

    @NotBlank(message = "Username is mandatory.")
    @NotEmpty(message = "Username is mandatory.")
    @Size(min = 3, max = 25, message = "Username must be between 5 and 25 characters.")
    @Pattern(regexp = "[a-zA-Z\\d]+", message = "Username can only contain letters and numbers.")
    private String username;

    @NotBlank(message = "Password is required!")
    @NotEmpty(message = "Password is required!")
    @Size(min = 10, max = 30, message = "Password must be between 10 and 30 characters.")
    @Pattern(regexp = "[a-zA-Z\\d #%'*/<()>:`;,!&.?_]+", message = "Only letters, numbers and punctuation marks are allowed.")
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
