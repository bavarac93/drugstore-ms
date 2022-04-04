package com.example.dms.rest;

import com.example.dms.dto.CustomerRequest;
import com.example.dms.dto.CustomerResponse;
import com.example.dms.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
