package com.example.dms.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.FutureOrPresent;
import java.time.LocalDate;

public class SupplierRequestPatch {
    @FutureOrPresent(message = "The date must be in the future or present. Otherwise, the contract is expired.")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate contractExpires;

    public LocalDate getContractExpires() {
        return contractExpires;
    }

    public void setContractExpires(LocalDate contractExpires) {
        this.contractExpires = contractExpires;
    }
}
