package com.example.dms.rest;

import com.example.dms.dto.AddressRequest;
import com.example.dms.dto.AddressResponse;
import com.example.dms.service.AddressService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.tomcat.jni.Local;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
