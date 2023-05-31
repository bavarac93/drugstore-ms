package com.pharma.dms.rest;

import com.pharma.dms.dto.FacilityRequest;
import com.pharma.dms.dto.FacilityResponse;
import com.pharma.dms.service.FacilityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("facility")
@Api(value = "APIs used to manipulate facility data", tags = "facility")
@Validated
public class FacilityController {
    private final FacilityService facilityService;

    public FacilityController(final FacilityService facilityService) {
        this.facilityService = Objects.requireNonNull(facilityService, "facilityService cannot be null");
    }

    @ApiOperation(value = "Create a facility",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping
    public ResponseEntity<FacilityResponse> create(@Valid @RequestBody final FacilityRequest facilityRequest) {
        return new ResponseEntity<>(facilityService.create(facilityRequest), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Get a facility by id",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("{id}")
    public ResponseEntity<FacilityResponse> findById(@PathVariable final Long id) {
        return new ResponseEntity<>(facilityService.findById(id), HttpStatus.FOUND);
    }

    @ApiOperation(value = "Get all facilities",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("get-all-stores")
    public ResponseEntity<List<FacilityResponse>> findAll() {
        return new ResponseEntity<>(facilityService.findAll(), HttpStatus.FOUND);
    }

    @ApiOperation(value = "Delete a facility by id", consumes = MediaType.APPLICATION_JSON_VALUE)
    @DeleteMapping("{id}")
    ResponseEntity<Void> deleteById(@PathVariable final Long id) {
        facilityService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
