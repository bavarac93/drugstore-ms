package com.example.dms.rest;

import com.example.dms.dto.OrdersRequest;
import com.example.dms.dto.OrdersResponse;
import com.example.dms.service.OrdersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
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

    @ApiOperation(value = "Get an order by id",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("{id}")
    ResponseEntity<OrdersResponse> findById(@PathVariable final Long id) {
        return new ResponseEntity<>(ordersService.findById(id), HttpStatus.FOUND);
    }

    @ApiOperation(value = "Delete an order by id", consumes = MediaType.APPLICATION_JSON_VALUE)
    @DeleteMapping("{id}")
    ResponseEntity<Void> deleteById(@PathVariable final Long id) {
        ordersService.findById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @ApiOperation(value = "Update an order by id",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @PutMapping("{id}")
    ResponseEntity<OrdersResponse> updateById(
            @PathVariable final Long id,
            @Valid @RequestBody final OrdersRequest ordersRequest
    ) {
        return new ResponseEntity<>(ordersService.updateById(id, ordersRequest), HttpStatus.ACCEPTED);
    }

    @ApiOperation(value = "Get orders made on specific date",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/get-orders-made-on/{dateTimeOrdered}")
    ResponseEntity<List<OrdersResponse>> findOrdersMadeOnSomeDate(
            @PathVariable @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") final LocalDateTime dateTimeOrdered
    ) {
        return new ResponseEntity<>(ordersService.findOrdersMadeOnSomeDate(dateTimeOrdered), HttpStatus.FOUND);
    }

    @ApiOperation(value = "Get orders made by same customer",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/get-orders-made-by-customer/{customerId}")
    ResponseEntity<List<OrdersResponse>> findOrdersMadeBySameCustomer(
            @PathVariable final Long customerId
    ) {
        return new ResponseEntity<>(ordersService.findOrdersMadeBySameCustomer(customerId), HttpStatus.FOUND);
    }

}
