package com.example.dms.rest;

import com.example.dms.dto.InventoryRequest;
import com.example.dms.dto.InventoryResponse;
import com.example.dms.service.InventoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping ("inventory")
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
        return new ResponseEntity<> (inventoryService.findAll(), HttpStatus.FOUND);
    }

    @ApiOperation(value = "Get an item by id",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("{id}")
    ResponseEntity<InventoryResponse> findById(@PathVariable final Long id) {
        return new ResponseEntity<>(inventoryService.findById(id), HttpStatus.FOUND);
    }

    @ApiOperation(value = "Delete an item by id",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
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
            @RequestBody final InventoryRequest inventoryRequest
    ) {
    return new ResponseEntity<>(inventoryService.updateById(id, inventoryRequest), HttpStatus.ACCEPTED);
    }

    @ApiOperation(value = "Update description by id",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @PatchMapping("/{id}")
    ResponseEntity<InventoryResponse> updateDescriptionById(
            @PathVariable ("id") final Long id,
            @RequestParam ("description") final String description
    ) {
      return new ResponseEntity<>(
              inventoryService.updateDescriptionById(id,description),
              HttpStatus.ACCEPTED
      );
    }

}
