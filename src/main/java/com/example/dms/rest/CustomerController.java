package com.example.dms.rest;

import com.example.dms.dto.CustomerRequest;
import com.example.dms.dto.CustomerResponse;
import com.example.dms.service.CustomerService;
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
@RequestMapping ("customer")
@Api(value = "APIs used to manipulate customer data", tags = "customer")
@Validated
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(final CustomerService customerService) {
        this.customerService = Objects.requireNonNull(customerService, "customerService cannot be null");
    }

    @ApiOperation(value = "Create a customer",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping
    public ResponseEntity<CustomerResponse> create(@Valid @RequestBody final CustomerRequest customerRequest) {
        return new ResponseEntity<> (customerService.create(customerRequest), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Get all customers", produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping
    public ResponseEntity<List<CustomerResponse>> findAll() {
        return new ResponseEntity<>(customerService.findAll(), HttpStatus.FOUND);
    }

    @ApiOperation(value = "Get a customer by id", produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("{id}")
    public ResponseEntity<CustomerResponse> findById(@PathVariable final Long id) {
        return new ResponseEntity<>(customerService.findById(id), HttpStatus.FOUND);
    }

    @ApiOperation(value = "Delete a customer by id", consumes = MediaType.APPLICATION_JSON_VALUE)
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(@PathVariable final Long id) {
        customerService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @ApiOperation(value = "Update a customer by id",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @PutMapping("{id}")
    public ResponseEntity<CustomerResponse> updateById(
            @PathVariable final Long id,
            @RequestBody final CustomerRequest customerRequest
    ) {
        return new ResponseEntity<>(customerService.updateById(id, customerRequest), HttpStatus.ACCEPTED);
    }

    @ApiOperation(value = "Update phone number by id",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @PatchMapping("/{id}")
    public ResponseEntity<CustomerResponse> updatePhoneNumberById(
            @PathVariable ("id") Long id,
            @RequestParam ("phoneNumber") String phoneNumber
    ){
        CustomerResponse customerResponse = customerService.updatePhoneNumberById(id, phoneNumber);
        return new ResponseEntity<>(customerResponse, HttpStatus.OK);
    }

    @ApiOperation(value = "Update verified status by id",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @PatchMapping("verified/{id}")
    public ResponseEntity<CustomerResponse> updateVerifiedStatus(
            @PathVariable ("id") Long id,
            @RequestParam ("email") String email
    ){
        CustomerResponse customerResponse = customerService.updateVerifiedStatus(id, email);
        return new ResponseEntity<>(customerResponse, HttpStatus.OK);
    }



}
