package com.example.dms.rest;

import com.example.dms.dto.InventoryRequest;
import com.example.dms.dto.InventoryResponse;
import com.example.dms.service.InventoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping ("inventory")
public class InventoryController {
    private final InventoryService inventoryService;

    public InventoryController(final InventoryService inventoryService) {
        this.inventoryService = Objects.requireNonNull(inventoryService, "inventoryService cannot be null");
    }

//    @PostMapping("{brandId}")
//    public String createInventory(@PathVariable final Long brandId) {
//        return inventoryService.create(brandId);
//    }

    @PostMapping("{brandId}")
    ResponseEntity<InventoryResponse> create(
            @RequestBody final InventoryRequest inventoryRequest,
            @PathVariable final Long brandId
            ) {
        return new ResponseEntity<>(inventoryService.create(inventoryRequest, brandId), HttpStatus.CREATED);
    }
}
