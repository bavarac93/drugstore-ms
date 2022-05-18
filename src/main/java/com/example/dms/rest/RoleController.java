package com.example.dms.rest;

import com.example.dms.dto.RoleRequest;
import com.example.dms.dto.RoleResponse;
import com.example.dms.service.RoleService;
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
public class RoleController {

    private final RoleService roleService;

    public RoleController(final RoleService roleService) {
        this.roleService = Objects.requireNonNull(roleService, "roleService cannot be null");
    }

    @ApiOperation(value = "Create a role",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping
    public ResponseEntity<RoleResponse> create(@Valid @RequestBody final RoleRequest roleRequest) {
        return new ResponseEntity<>(roleService.create(roleRequest), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Retrieve all roles", produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping
    public ResponseEntity<List<RoleResponse>> findAll() {
        return new ResponseEntity<>(roleService.findAll(), HttpStatus.FOUND);
    }

    @ApiOperation(value = "Retrieve a role by name",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("{name}")
    public ResponseEntity<RoleResponse> findRoleByName(@PathVariable final String name) {
        return new ResponseEntity<>(roleService.findRoleByName(name), HttpStatus.FOUND);
    }

    @ApiOperation(value = "Delete a role by id", consumes = MediaType.APPLICATION_JSON_VALUE)
    @DeleteMapping("{id}")
    ResponseEntity<Void> deleteById(@PathVariable final Long id) {
        roleService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
