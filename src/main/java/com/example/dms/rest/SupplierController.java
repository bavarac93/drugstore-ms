package com.example.dms.rest;

import com.example.dms.service.SupplierService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("supplier")
public class SupplierController {

    private final SupplierService supplierService;

    public SupplierController(final SupplierService supplierService) {
        this.supplierService = Objects.requireNonNull(supplierService, "supplierService cannot be null");
    }


}
