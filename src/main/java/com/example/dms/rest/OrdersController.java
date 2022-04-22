package com.example.dms.rest;

import com.example.dms.dto.OrdersRequest;
import com.example.dms.dto.OrdersResponse;
import com.example.dms.service.OrdersService;
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
@RequestMapping ("orders")
@Api(value = "APIs used to manipulate orders data", tags = "orders")
@Validated
public class OrdersController {

    private final OrdersService ordersService;

    public OrdersController(final OrdersService ordersService) {
        this.ordersService = Objects.requireNonNull(ordersService, "ordersService cannot be null");
    }

    @ApiOperation(value = "Create an order",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping
    ResponseEntity<OrdersResponse> create(@Valid @RequestBody final OrdersRequest ordersRequest) {
        return new ResponseEntity<>(ordersService.create(ordersRequest), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Retrieve all orders", produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping
    ResponseEntity<List<OrdersResponse>> findAllOrders() {
        return new ResponseEntity<>(ordersService.findAllOrders(), HttpStatus.FOUND);
    }

    @ApiOperation(value = "Get an item by id",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("{id}")
    ResponseEntity<OrdersResponse> findById(@PathVariable final Long id) {
        return new ResponseEntity<>(ordersService.findById(id), HttpStatus.FOUND);
    }

}
