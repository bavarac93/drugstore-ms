package com.example.dms.rest;

import com.example.dms.dto.CustomerRequest;
import com.example.dms.dto.CustomerResponse;
import com.example.dms.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping ("customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(final CustomerService customerService) {
        this.customerService = Objects.requireNonNull(customerService, "customerService cannot be null");
    }

    @PostMapping
    public ResponseEntity<CustomerResponse> create(@RequestBody final CustomerRequest customerRequest) {
        return new ResponseEntity<> (customerService.create(customerRequest), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CustomerResponse>> findAll() {
        return new ResponseEntity<>(customerService.findAll(), HttpStatus.FOUND);
    }

    @GetMapping("{id}")
    public ResponseEntity<CustomerResponse> findById(@PathVariable final Long id) {
        return new ResponseEntity<>(customerService.findById(id), HttpStatus.FOUND);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(@PathVariable final Long id) {
        customerService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("{id}")
    public ResponseEntity<CustomerResponse> updateById(
            @PathVariable final Long id,
            @RequestBody final CustomerRequest customerRequest
    ) {
        return new ResponseEntity<>(customerService.updateById(id, customerRequest), HttpStatus.ACCEPTED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<CustomerResponse> updatePhoneNumberById(
            @PathVariable ("id") Long id,
            @RequestParam ("phoneNumber") String phoneNumber
    ){
        CustomerResponse customerResponse = customerService.updatePhoneNumberById(id, phoneNumber);
        return new ResponseEntity<>(customerResponse, HttpStatus.OK);
    }

    @PatchMapping("verified/{id}")
    public ResponseEntity<CustomerResponse> updateVerifiedStatus(
            @PathVariable ("id") Long id,
            @RequestParam ("email") String email
    ){
        CustomerResponse customerResponse = customerService.updateVerifiedStatus(id, email);
        return new ResponseEntity<>(customerResponse, HttpStatus.OK);
    }



}
