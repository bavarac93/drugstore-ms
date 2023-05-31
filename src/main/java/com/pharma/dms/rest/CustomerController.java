package com.pharma.dms.rest;

import com.pharma.dms.dto.CustomerRequest;
import com.pharma.dms.dto.CustomerRequestPhoneNumberPatch;
import com.pharma.dms.dto.CustomerRequestVerifiedPatch;
import com.pharma.dms.dto.CustomerResponse;
import com.pharma.dms.service.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.jetbrains.annotations.NotNull;
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
@RequestMapping("customer")
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
        return new ResponseEntity<>(customerService.create(customerRequest), HttpStatus.CREATED);
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
            @Valid @RequestBody final CustomerRequest customerRequest
    ) {
        return new ResponseEntity<>(customerService.updateById(id, customerRequest), HttpStatus.ACCEPTED);
    }

    @ApiOperation(value = "Update phone number by id",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @PatchMapping("/{id}")
    public ResponseEntity<CustomerResponse> updatePhoneNumberById(
            @PathVariable("id") final Long id,
            @Valid @RequestBody final CustomerRequestPhoneNumberPatch customerRequestPhoneNumberPatch
    ) {
        CustomerResponse customerResponse = customerService.updatePhoneNumberById(id, customerRequestPhoneNumberPatch);
        return new ResponseEntity<>(customerResponse, HttpStatus.OK);
    }

    @ApiOperation(value = "Get all verified customers", produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("get-verified-customers")
    public ResponseEntity<List<CustomerResponse>> findVerifiedCustomers() {
        return new ResponseEntity<>(customerService.findVerifiedCustomers(), HttpStatus.FOUND);
    }

    @ApiOperation(value = "Get all customers with allergies",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/get-allergic-customers/{drugAllergicTo}")
    public ResponseEntity<List<CustomerResponse>> findAllergicCustomers(@PathVariable final String drugAllergicTo) {
        return new ResponseEntity<>(customerService.findAllergicCustomers(drugAllergicTo), HttpStatus.FOUND);
    }

    @ApiOperation(value = "Count customers with allergies",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("count-allergic-customers-to-some-medication/{drugAllergicTo}")
    public ResponseEntity<String> countAllergicCustomersToSomeDrug(@PathVariable final @NotNull String drugAllergicTo) {
        return new ResponseEntity<>(customerService.countAllergicCustomersToSomeDrug(drugAllergicTo), HttpStatus.FOUND);
    }

    @ApiOperation(value = "Update verified status by id",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @PatchMapping("verified/{id}")
    public ResponseEntity<CustomerResponse> updateVerifiedStatus(
            @PathVariable("id") final Long id,
            @Valid @RequestBody final CustomerRequestVerifiedPatch CustomerRequestVerifiedPatch

    ) {
        CustomerResponse customerResponse = customerService.updateVerifiedStatus(id, CustomerRequestVerifiedPatch);
        return new ResponseEntity<>(customerResponse, HttpStatus.OK);
    }
}
