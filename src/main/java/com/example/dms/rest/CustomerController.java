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



}
