package com.example.dms.rest;

import com.example.dms.dto.InventoryRequest;
import com.example.dms.dto.InventoryRequestPatch;
import com.example.dms.dto.InventoryResponse;
import com.example.dms.service.InventoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("inventory")
@Api(value = "APIs used to manipulate inventory data", tags = "inventory")
@Validated
public class InventoryController {

    private final InventoryService inventoryService;

    public InventoryController(final InventoryService inventoryService) {
        this.inventoryService = Objects.requireNonNull(inventoryService, "inventoryService cannot be null");
    }

    @ApiOperation(value = "Create an item",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping
    ResponseEntity<InventoryResponse> create(@Valid @RequestBody final InventoryRequest inventoryRequest) {
        return new ResponseEntity<>(inventoryService.create(inventoryRequest), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Retrieve all items", produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping
    ResponseEntity<List<InventoryResponse>> findAll() {
        return new ResponseEntity<>(inventoryService.findAll(), HttpStatus.FOUND);
    }

    @ApiOperation(value = "Get an item by id",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("{id}")
    ResponseEntity<InventoryResponse> findById(@PathVariable final Long id) {
        return new ResponseEntity<>(inventoryService.findById(id), HttpStatus.FOUND);
    }

    @ApiOperation(value = "Delete an item by id", consumes = MediaType.APPLICATION_JSON_VALUE)
    @DeleteMapping("{id}")
    ResponseEntity<Void> deleteById(@PathVariable final Long id) {
        inventoryService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @ApiOperation(value = "Update an item by id",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @PutMapping("{id}")
    ResponseEntity<InventoryResponse> updateById(
            @PathVariable final Long id,
            @Valid @RequestBody final InventoryRequest inventoryRequest
    ) {
        return new ResponseEntity<>(inventoryService.updateById(id, inventoryRequest), HttpStatus.ACCEPTED);
    }

    @ApiOperation(value = "Update description by id",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @PatchMapping("/{id}")
    ResponseEntity<InventoryResponse> updateDescriptionById(
            @PathVariable("id") final Long id,
            @Valid @RequestBody final InventoryRequestPatch inventoryRequestPatch
    ) {
        return new ResponseEntity<>(
                inventoryService.updateDescriptionById(id, inventoryRequestPatch),
                HttpStatus.ACCEPTED
        );
    }

    @ApiOperation(value = "Get items by specific date",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/get-items-by-expiry-date/{expiryDate}")
    ResponseEntity<List<InventoryResponse>> findAllWithExpiryTimeBefore(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") final LocalDate expiryDate) {
        return new ResponseEntity<>(inventoryService.findAllWithExpiryTimeBefore(expiryDate), HttpStatus.FOUND);
    }

    @ApiOperation(value = "Get items made by the same brand",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/get-items-by-same-brand/{brandId}")
    ResponseEntity<List<InventoryResponse>> findItemsMadeByTheSameBrand(@PathVariable final Long brandId) {
        return new ResponseEntity<>(inventoryService.findItemsMadeByTheSameBrand(brandId), HttpStatus.FOUND);
    }

    @ApiOperation(value = "Count items made by the same brand",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/count-items-by-same-brand/{brandId}")
    ResponseEntity<String> countItemsMadeByTheSameBrand(@PathVariable final Long brandId) {
        return new ResponseEntity<>(inventoryService.countItemsMadeByTheSameBrand(brandId), HttpStatus.FOUND);
    }

    @ApiOperation(value = "Get items of the same type",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/get-items-of-same-type/{productTypeId}")
    ResponseEntity<List<InventoryResponse>> findItemsOfTheSameType(@PathVariable final Long productTypeId) {
        return new ResponseEntity<>(inventoryService.findItemsOfTheSameType(productTypeId), HttpStatus.FOUND);
    }

    @ApiOperation(value = "Get items of the same supplier",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/get-items-from-same-supplier/{supplierId}")
    ResponseEntity<List<InventoryResponse>> findItemsFromTheSameSupplier(@PathVariable final Long supplierId) {
        return new ResponseEntity<>(inventoryService.findItemsFromTheSameSupplier(supplierId), HttpStatus.FOUND);
    }

    @ApiOperation(value = "Count items of the same type",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/count-items-of-same-type/{productTypeId}")
    ResponseEntity<String> countItemsOfTheSameType(@PathVariable final Long productTypeId) {
        return new ResponseEntity<>(inventoryService.countItemsOfTheSameType(productTypeId), HttpStatus.FOUND);
    }

    @ApiOperation(value = "Count items of the same type",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/count-items-from-same-supplier/{supplierId}")
    ResponseEntity<String> countItemsFromTheSameSupplier(@PathVariable final Long supplierId) {
        return new ResponseEntity<>(inventoryService.countItemsFromTheSameSupplier(supplierId), HttpStatus.FOUND);
    }
}
