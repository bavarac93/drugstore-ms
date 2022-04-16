package com.example.dms.rest;

import com.example.dms.service.ProductTypeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping ("product_type")
public class ProductTypeController {

    private final ProductTypeService productTypeService;
    public ProductTypeController(final ProductTypeService productTypeService) {
        this.productTypeService = Objects.requireNonNull(productTypeService, "productTypeService cannot be null");
    }
}
