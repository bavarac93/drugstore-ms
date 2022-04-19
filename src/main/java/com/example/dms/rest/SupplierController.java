package com.example.dms.rest;

import com.example.dms.dto.SupplierRequest;
import com.example.dms.dto.SupplierResponse;
import com.example.dms.service.SupplierService;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("supplier")
@Api(value = "APIs used to manipulate supplier data", tags = "supplier")
@Validated
public class SupplierController {

    private final SupplierService supplierService;

    public SupplierController(final SupplierService supplierService) {
        this.supplierService = Objects.requireNonNull(supplierService, "supplierService cannot be null");
    }

    @PostMapping
    ResponseEntity<SupplierResponse> create(@Valid @RequestBody final SupplierRequest supplierRequest) {
        return new ResponseEntity<>(supplierService.create(supplierRequest), HttpStatus.CREATED);
    }

    @GetMapping
    ResponseEntity<List<SupplierResponse>> findAll() {
        return new ResponseEntity<>(supplierService.findAll(), HttpStatus.FOUND);
    }

    @GetMapping("{id}")
    ResponseEntity<SupplierResponse> findById(@PathVariable final Long id) {
        return new ResponseEntity<>(supplierService.findById(id), HttpStatus.FOUND);
    }

    @DeleteMapping ("{id}")
    ResponseEntity<Void> deleteById(@PathVariable final Long id) {
        supplierService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping ("{id}")
    ResponseEntity<SupplierResponse> updateById (
            @PathVariable final Long id,
            @RequestBody final SupplierRequest supplierRequest
    ) {
        return new ResponseEntity<>(supplierService.updateById(id, supplierRequest), HttpStatus.ACCEPTED);
    }

    @PatchMapping("/{id}")
    ResponseEntity<SupplierResponse> updateContractExpiresById(
            @PathVariable ("id") final Long id,
            @RequestParam ("contractExpires") final LocalDateTime contractExpires
    ) {
        return new ResponseEntity<>(supplierService.updateContractExpiresById(id, contractExpires), HttpStatus.ACCEPTED);
    }


}