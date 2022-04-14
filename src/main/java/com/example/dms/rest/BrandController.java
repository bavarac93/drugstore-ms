package com.example.dms.rest;

import com.example.dms.dto.BrandRequest;
import com.example.dms.dto.BrandResponse;
import com.example.dms.service.BrandService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("brand")
public class BrandController {

    private final BrandService brandService;

    public BrandController(final BrandService brandService) {
        this.brandService = Objects.requireNonNull(brandService, "brandService cannot be null");
    }

//    @PostMapping
//    public String create() {
//        return brandService.create();
//    }

    @PostMapping
    ResponseEntity<BrandResponse> create(@RequestBody final BrandRequest brandRequest) {
        return new ResponseEntity<> (brandService.create(brandRequest), HttpStatus.CREATED);
    }

    @GetMapping
    ResponseEntity<List<BrandResponse>> findAll() {
        return new ResponseEntity<>(brandService.findAll(), HttpStatus.FOUND);
    }


}
