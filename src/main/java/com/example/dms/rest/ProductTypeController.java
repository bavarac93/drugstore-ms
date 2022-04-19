package com.example.dms.rest;

import com.example.dms.dto.ProductTypeRequest;
import com.example.dms.dto.ProductTypeResponse;
import com.example.dms.service.ProductTypeService;
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
@RequestMapping ("product_type")
@Api(value = "APIs used to manipulate product type data", tags = "product type")
@Validated
public class ProductTypeController {

    private final ProductTypeService productTypeService;
    public ProductTypeController(final ProductTypeService productTypeService) {
        this.productTypeService = Objects.requireNonNull(productTypeService, "productTypeService cannot be null");
    }
    @ApiOperation(value = "Create a product type",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping
    ResponseEntity<ProductTypeResponse> create(@Valid @RequestBody final ProductTypeRequest productTypeRequest) {
        return new ResponseEntity<>(productTypeService.create(productTypeRequest), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Retrieve all product types", produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping
    ResponseEntity<List<ProductTypeResponse>> findAll() {
        return new ResponseEntity<>(productTypeService.findAll(), HttpStatus.FOUND);
    }

    @ApiOperation(value = "Get a product type by id",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("{id}")
    ResponseEntity<ProductTypeResponse> findById(@PathVariable final Long id) {
        return new ResponseEntity<>(productTypeService.findById(id), HttpStatus.FOUND);
    }

    @ApiOperation(value = "Delete by id",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @DeleteMapping("{id}")
    ResponseEntity<Void> deleteById(@PathVariable final Long id) {
        productTypeService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @ApiOperation(value = "Update a product type by id",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @PutMapping("{id}")
    ResponseEntity<ProductTypeResponse> updateById(
            @PathVariable Long id,
            @RequestBody ProductTypeRequest productTypeRequest
    ) {
        return new ResponseEntity<>(productTypeService.updateById(id, productTypeRequest), HttpStatus.ACCEPTED);
    }

    @ApiOperation(value = "Update a product description by id",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @PatchMapping("/{id}")
    ResponseEntity<ProductTypeResponse> updateProductTypeDescById(
            @PathVariable ("id") final Long id,
            @RequestParam ("productTypeDesc") final String productTypeDesc
    ) {
      return new ResponseEntity<>(productTypeService.updateProductTypeDescById(id, productTypeDesc), HttpStatus.ACCEPTED);
    }


}
