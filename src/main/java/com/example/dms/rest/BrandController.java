package com.example.dms.rest;

import com.example.dms.dto.BrandRequest;
import com.example.dms.dto.BrandRequestPatch;
import com.example.dms.dto.BrandResponse;
import com.example.dms.service.BrandService;
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
@RequestMapping("brand")
@Api(value = "APIs used to manipulate brand data", tags = "brand")
@Validated
public class BrandController {

    private final BrandService brandService;

    public BrandController(final BrandService brandService) {
        this.brandService = Objects.requireNonNull(brandService, "brandService cannot be null");
    }

    @ApiOperation(value = "Create a brand",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping
    ResponseEntity<BrandResponse> create(@Valid @RequestBody final BrandRequest brandRequest) {
        return new ResponseEntity<> (brandService.create(brandRequest), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Get all brands", produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping
    ResponseEntity<List<BrandResponse>> findAll() {
        return new ResponseEntity<>(brandService.findAll(), HttpStatus.FOUND);
    }

    @ApiOperation(value = "Get a brand by id", produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("{id}")
    ResponseEntity<BrandResponse> findById(@PathVariable final Long id) {
        return new ResponseEntity<>(brandService.findById(id), HttpStatus.FOUND);
    }

    @ApiOperation(value = "Delete a brand by id", consumes = MediaType.APPLICATION_JSON_VALUE)
    @DeleteMapping("{id}")
    ResponseEntity<Void> deleteById(@PathVariable final Long id) {
        brandService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @ApiOperation(value = "Update a brand by id",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @PutMapping("{id}")
    ResponseEntity<BrandResponse> updateById(
            @PathVariable final Long id,
            @Valid @RequestBody final BrandRequest brandRequest
    ) {
        return new ResponseEntity<>(brandService.updateById(id, brandRequest), HttpStatus.ACCEPTED);
    }

    @ApiOperation(value = "Get all brands by a specific name",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("get-all-brands/{brandName}")
    public ResponseEntity<List<BrandResponse>> findAllBrandsBySomeName(@PathVariable final String brandName) {
        return new ResponseEntity<>(brandService.findAllBrandsBySomeName(brandName), HttpStatus.FOUND);
    }


    @ApiOperation(value = "Update brand description by id",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @PatchMapping("/{id}")
    ResponseEntity<BrandResponse> updateBrandDescById(
            @PathVariable ("id") final Long id,
            @Valid @RequestBody final BrandRequestPatch brandRequestPatch
            ) {
        BrandResponse brandResponse = brandService.updateBrandDescById(id, brandRequestPatch);
        return new ResponseEntity<>(brandResponse, HttpStatus.OK);
    }


}
