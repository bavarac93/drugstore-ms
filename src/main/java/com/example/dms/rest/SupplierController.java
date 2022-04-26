package com.example.dms.rest;

import com.example.dms.dto.SupplierRequest;
import com.example.dms.dto.SupplierRequestPatch;
import com.example.dms.dto.SupplierResponse;
import com.example.dms.service.SupplierService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
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

    @ApiOperation(value = "Create a supplier",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping
    ResponseEntity<SupplierResponse> create(@Valid @RequestBody final SupplierRequest supplierRequest) {
        return new ResponseEntity<>(supplierService.create(supplierRequest), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Retrieve all suppliers", produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping
    ResponseEntity<List<SupplierResponse>> findAll() {
        return new ResponseEntity<>(supplierService.findAll(), HttpStatus.FOUND);
    }

    @ApiOperation(value = "Retrieve a supplier by id",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("{id}")
    ResponseEntity<SupplierResponse> findById(@PathVariable final Long id) {
        return new ResponseEntity<>(supplierService.findById(id), HttpStatus.FOUND);
    }

    @ApiOperation(value = "Delete a supplier by id", consumes = MediaType.APPLICATION_JSON_VALUE)
    @DeleteMapping ("{id}")
    ResponseEntity<Void> deleteById(@PathVariable final Long id) {
        supplierService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @ApiOperation(value = "Update a supplier by id",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @PutMapping ("{id}")
    ResponseEntity<SupplierResponse> updateById (
            @PathVariable final Long id,
            @Valid @RequestBody final SupplierRequest supplierRequest
    ) {
        return new ResponseEntity<>(supplierService.updateById(id, supplierRequest), HttpStatus.ACCEPTED);
    }

    @ApiOperation(value = "Update a contract expiry date by id",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @PatchMapping("/{id}")
    ResponseEntity<SupplierResponse> updateContractExpiresById(
            @PathVariable ("id") final Long id,
            @Valid @RequestBody final SupplierRequestPatch supplierRequestPatch
            ) {
        return new ResponseEntity<>(supplierService.updateContractExpiresById(id, supplierRequestPatch), HttpStatus.ACCEPTED);
    }

    @ApiOperation(value = "Get suppliers that signed contracts on specific date",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/get-suppliers-contract-signed-on/{contractSigned}")
    ResponseEntity<List<SupplierResponse>> findAllWithContractSignedOn(
            @PathVariable @DateTimeFormat(pattern="yyyy-MM-dd") final LocalDate contractSigned
    ) {
        return new ResponseEntity<>(supplierService.findAllWithContractSignedOn(contractSigned), HttpStatus.FOUND);
    }

    @ApiOperation(value = "Get suppliers whose contract expires on specific date",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/get-suppliers-contract-expires-on/{contractExpires}")
    ResponseEntity<List<SupplierResponse>> findAllWithContractExpiresOn(
            @PathVariable @DateTimeFormat(pattern="yyyy-MM-dd") final LocalDate contractExpires
    ) {
        return new ResponseEntity<>(supplierService.findAllWithContractExpiresOn(contractExpires), HttpStatus.FOUND);
    }

}
