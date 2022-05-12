package com.example.dms.rest;

import com.example.dms.dto.RoleToUserForm;
import com.example.dms.dto.UserRequest;
import com.example.dms.dto.UserResponse;
import com.example.dms.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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
@RequestMapping("/user")
@Api(value = "APIs used to manipulate user data", tags = "user")
@Validated
public class UserController {

    private final UserService userService;

    public UserController(final UserService userService) {
        this.userService = Objects.requireNonNull(userService, "userService cannot be null");
    }

    @ApiOperation(value = "Create a user",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping
    public ResponseEntity<UserResponse> create(@Valid @RequestBody final UserRequest userRequest) {
        return new ResponseEntity<>(userService.create(userRequest), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Retrieve all users", produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping
    public ResponseEntity<List<UserResponse>> findAll() {
        return new ResponseEntity<>(userService.findAll(), HttpStatus.FOUND);
    }

    @ApiOperation(value = "Retrieve a user by username",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("{username}")
    public ResponseEntity<UserResponse> findUserByUsername(@PathVariable final String username) {
        return new ResponseEntity<>(userService.findUserByUsername(username), HttpStatus.FOUND);
    }

    @ApiOperation(value = "Add a role to a user",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("/add-role-to-user")
    public ResponseEntity<?> addRoleToUser(@Valid @RequestBody @NotNull RoleToUserForm form) {
        userService.addRoleToUser(form.getUsername(), form.getRoleName());
        return ResponseEntity.ok().build();
    }
}

