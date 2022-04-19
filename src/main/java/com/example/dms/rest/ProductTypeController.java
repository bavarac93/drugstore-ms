package com.example.dms.rest;

import com.example.dms.dto.ProductTypeRequest;
import com.example.dms.dto.ProductTypeResponse;
import com.example.dms.service.ProductTypeService;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
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

    @PostMapping
    ResponseEntity<ProductTypeResponse> create(@Valid @RequestBody final ProductTypeRequest productTypeRequest) {
        return new ResponseEntity<>(productTypeService.create(productTypeRequest), HttpStatus.CREATED);
    }

    @GetMapping
    ResponseEntity<List<ProductTypeResponse>> findAll() {
        return new ResponseEntity<>(productTypeService.findAll(), HttpStatus.FOUND);
    }

    @GetMapping("{id}")
    ResponseEntity<ProductTypeResponse> findById(@PathVariable final Long id) {
        return new ResponseEntity<>(productTypeService.findById(id), HttpStatus.FOUND);
    }

    @DeleteMapping("{id}")
    ResponseEntity<Void> deleteById(@PathVariable final Long id) {
        productTypeService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("{id}")
    ResponseEntity<ProductTypeResponse> updateById(
            @PathVariable Long id,
            @RequestBody ProductTypeRequest productTypeRequest
    ) {
        return new ResponseEntity<>(productTypeService.updateById(id, productTypeRequest), HttpStatus.ACCEPTED);
    }

    @PatchMapping("/{id}")
    ResponseEntity<ProductTypeResponse> updateProductTypeDescById(
            @PathVariable ("id") final Long id,
            @RequestParam ("productTypeDesc") final String productTypeDesc
    ) {
      return new ResponseEntity<>(productTypeService.updateProductTypeDescById(id, productTypeDesc), HttpStatus.ACCEPTED);
    }


}
