package com.example.dms.rest;

import io.swagger.annotations.Api;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("orders")
@Api(value = "APIs used to manipulate orders data", tags = "orders")
@Validated
public class OrdersController {
}
