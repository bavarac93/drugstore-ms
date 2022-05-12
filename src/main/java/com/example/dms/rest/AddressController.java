package com.example.dms.rest;

import com.example.dms.dto.AddressRequest;
import com.example.dms.dto.AddressRequestPatch;
import com.example.dms.dto.AddressResponse;
import com.example.dms.service.AddressService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("address")
@Api(value = "APIs used to manipulate address data", tags = "address")
@Validated
public class AddressController {
    private final AddressService addressService;

    public AddressController(final AddressService addressService) {
        this.addressService = Objects.requireNonNull(addressService, "addressService cannot be null");
    }

    @ApiOperation(value = "Create new address",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping
    public ResponseEntity<AddressResponse> create(@Valid @RequestBody final AddressRequest addressRequest) {
        return new ResponseEntity<>(addressService.create(addressRequest), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Retrieve all addresses", produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping
    public ResponseEntity<List<AddressResponse>> findAll() {
        return new ResponseEntity<>(addressService.findAll(), HttpStatus.FOUND);
    }

    @ApiOperation(value = "Retrieve an address by id",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("{id}")
    public ResponseEntity<AddressResponse> findById(@PathVariable final Long id) {
        return new ResponseEntity<>(addressService.findById(id), HttpStatus.FOUND);
    }

    @ApiOperation(value = "Delete an address by id", consumes = MediaType.APPLICATION_JSON_VALUE)
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(@PathVariable final Long id) {
        addressService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @ApiOperation(value = "Update an address by id",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @PutMapping("{id}")
    public ResponseEntity<AddressResponse> updateById(
            @PathVariable final Long id,
            @Valid @RequestBody final AddressRequest addressRequest
    ) {
        return new ResponseEntity<>(addressService.updateById(id, addressRequest), HttpStatus.ACCEPTED);
    }

    @ApiOperation(value = "Get all addresses in the same city",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("get-addresses-in-the-same-city/{city}")
    public ResponseEntity<List<AddressResponse>> findAddressesInTheSameCity(@PathVariable final String city) {
        return new ResponseEntity<>(addressService.findAddressesInTheSameCity(city), HttpStatus.FOUND);
    }

    @ApiOperation(value = "Update the building number and street by id",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @PatchMapping("/{id}")
    public ResponseEntity<AddressResponse> updateStreetAndBuildingNumberById(
            @PathVariable("id") final Long id,
            @Valid @RequestBody final AddressRequestPatch addressRequestPatch
    ) {
        AddressResponse addressResponse = addressService.updateStreetAndBuildingNumberById(id, addressRequestPatch);
        return new ResponseEntity<>(addressResponse, HttpStatus.OK);
    }

}
