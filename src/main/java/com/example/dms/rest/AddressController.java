package com.example.dms.rest;

import com.example.dms.dto.AddressRequest;
import com.example.dms.dto.AddressResponse;
import com.example.dms.service.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("address")
public class AddressController {

    private final AddressService addressService;

    public AddressController(final AddressService addressService) {
        this.addressService = Objects.requireNonNull(addressService, "addressService cannot be null");
    }

    @PostMapping
    public ResponseEntity<AddressResponse> create(@RequestBody final AddressRequest addressRequest) {
        return new ResponseEntity<>(addressService.create(addressRequest), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<AddressResponse>> findAll() {
        return new ResponseEntity<>(addressService.findAll(), HttpStatus.FOUND);
    }

    @GetMapping("{id}")
    public ResponseEntity<AddressResponse> findById(@PathVariable final Long id) {
        return new ResponseEntity<>(addressService.findById(id), HttpStatus.FOUND);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(@PathVariable final Long id) {
        addressService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("{id}")
    public ResponseEntity<AddressResponse> updateById(
            @PathVariable final Long id,
            @RequestBody final AddressRequest addressRequest
    ) {
        return new ResponseEntity<>(addressService.updateById(id, addressRequest), HttpStatus.ACCEPTED);
    }

    @PatchMapping ("/{id}")
    public ResponseEntity<AddressResponse> updateStreetAndBuildingNumberById(
            @RequestParam("buildingNumber") String buildingNumber,
            @RequestParam("street") String street,
            @PathVariable("id") Long id
    ) {
        AddressResponse addressResponse = addressService.updateStreetAndBuildingNumberById(id, buildingNumber, street);
        return new ResponseEntity<>(addressResponse, HttpStatus.OK);
    }

}
