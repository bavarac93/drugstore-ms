package com.pharma.dms.rest;

import com.pharma.dms.dto.RoleToUserForm;
import com.pharma.dms.dto.UsersRequest;
import com.pharma.dms.dto.UsersResponse;
import com.pharma.dms.service.UsersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.jetbrains.annotations.NotNull;
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
@RequestMapping("user")
@Api(value = "APIs used to manipulate user data", tags = "user")
@Validated
public class UsersController {

    private final UsersService usersService;

    public UsersController(final UsersService usersService) {
        this.usersService = Objects.requireNonNull(usersService, "usersService cannot be null");
    }

    @ApiOperation(value = "Create a user",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping
    public ResponseEntity<UsersResponse> create(@Valid @RequestBody final UsersRequest usersRequest) {
        return new ResponseEntity<>(usersService.create(usersRequest), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Retrieve all users", produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping
    public ResponseEntity<List<UsersResponse>> findAll() {
        return new ResponseEntity<>(usersService.findAll(), HttpStatus.FOUND);
    }

    @ApiOperation(value = "Retrieve a user by username",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/find-user-by-username/{username}")
    public ResponseEntity<UsersResponse> findUserByUsername(@PathVariable final String username) {
        return new ResponseEntity<>(usersService.findUserByUsername(username), HttpStatus.FOUND);
    }

    @ApiOperation(value = "Add a role to a user",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("/add-role-to-user")
    public ResponseEntity<?> addRoleToUser(@Valid @RequestBody @NotNull RoleToUserForm form) {
        usersService.addRoleToUser(form.getUsername(), form.getRoleName());
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "Delete a user by id", consumes = MediaType.APPLICATION_JSON_VALUE)
    @DeleteMapping("{id}")
    ResponseEntity<Void> deleteById(@PathVariable final Long id) {
        usersService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

