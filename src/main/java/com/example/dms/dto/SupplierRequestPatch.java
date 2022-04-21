package com.example.dms.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.FutureOrPresent;
import java.time.LocalDateTime;

public class SupplierRequestPatch {
    @FutureOrPresent(message = "The date must be in the future or present. Otherwise, the contract is expired.")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime contractExpires;

    public LocalDateTime getContractExpires() {
        return contractExpires;
    }

    public void setContractExpires(LocalDateTime contractExpires) {
        this.contractExpires = contractExpires;
    }
}
