package com.example.dms.rest;

import com.example.dms.dto.InventoryRequest;
import com.example.dms.dto.InventoryResponse;
import com.example.dms.service.InventoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping ("inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    public InventoryController(final InventoryService inventoryService) {
        this.inventoryService = Objects.requireNonNull(inventoryService, "inventoryService cannot be null");
    }

    @PostMapping
    ResponseEntity<InventoryResponse> create(@RequestBody final InventoryRequest inventoryRequest) {
        return new ResponseEntity<>(inventoryService.create(inventoryRequest), HttpStatus.CREATED);
    }

    @GetMapping
    ResponseEntity<List<InventoryResponse>> findAll() {
        return new ResponseEntity<> (inventoryService.findAll(), HttpStatus.FOUND);
    }

    @GetMapping("{id}")
    ResponseEntity<InventoryResponse> findById(@PathVariable final Long id) {
        return new ResponseEntity<>(inventoryService.findById(id), HttpStatus.FOUND);
    }

    @DeleteMapping("{id}")
    ResponseEntity<Void> deleteById(@PathVariable final Long id) {
        inventoryService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("{id}")
    ResponseEntity<InventoryResponse> updateById(
            @PathVariable final Long id,
            @RequestBody final InventoryRequest inventoryRequest
    ) {
    return new ResponseEntity<>(inventoryService.updateById(id, inventoryRequest), HttpStatus.ACCEPTED);
    }

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
