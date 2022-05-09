package com.example.dms.rest;

import com.example.dms.model.RoleToUserForm;
import com.example.dms.model.UserEntity;
import com.example.dms.service.UserService;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/security")
public class UserController {

    private final UserService userService;

    public UserController(final UserService userService) {
        this.userService = Objects.requireNonNull(userService, "userService cannot be null");
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserEntity>> getUsers() {
        return new ResponseEntity<>(userService.getUsers(), HttpStatus.FOUND);
    }

    @PostMapping("/user/save")
    public ResponseEntity<UserEntity> saveUser(@RequestBody final UserEntity userEntity) {
        return new ResponseEntity<>(userService.saveUser(userEntity), HttpStatus.CREATED);
    }

    @PostMapping("/user/add-role-to-user")
    public ResponseEntity<?>addRoleToUser(@RequestBody @NotNull RoleToUserForm form) {
        userService.addRoleToUser(form.getUsername(), form.getRoleName());
        return ResponseEntity.ok().build();
    }
}

