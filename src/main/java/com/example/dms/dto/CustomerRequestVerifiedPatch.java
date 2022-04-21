package com.example.dms.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class CustomerRequestVerifiedPatch {
    @NotBlank(message = "The email is obligatory.")
    @NotEmpty(message = "The email is obligatory.")
    @Email(flags = Pattern.Flag.CASE_INSENSITIVE, message = "Email must be a valid email address, e.g. example@mail.com")
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
