package com.example.dms.rest;

import com.example.dms.dto.RolesRequest;
import com.example.dms.dto.RolesResponse;
import com.example.dms.service.RolesService;
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
@RequestMapping("role")
@Api(value = "APIs used to manipulate role data", tags = "role")
@Validated
public class RolesController {

    private final RolesService rolesService;

    public RolesController(final RolesService rolesService) {
        this.rolesService = Objects.requireNonNull(rolesService, "rolesService cannot be null");
    }

    @ApiOperation(value = "Create a role",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping
    public ResponseEntity<RolesResponse> create(@Valid @RequestBody final RolesRequest rolesRequest) {
        return new ResponseEntity<>(rolesService.create(rolesRequest), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Retrieve all roles", produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping
    public ResponseEntity<List<RolesResponse>> findAll() {
        return new ResponseEntity<>(rolesService.findAll(), HttpStatus.FOUND);
    }

    @ApiOperation(value = "Retrieve all roles by same name",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/find-roles-by-name/{name}")
    public ResponseEntity<List<RolesResponse>> findAllRolesByName(@PathVariable final String name) {
        return new ResponseEntity<>(rolesService.findAllRolesByName(name), HttpStatus.FOUND);
    }

    @ApiOperation(value = "Delete a role by id", consumes = MediaType.APPLICATION_JSON_VALUE)
    @DeleteMapping("{id}")
    ResponseEntity<Void> deleteById(@PathVariable final Long id) {
        rolesService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
