package com.example.dms.rest;

import com.example.dms.security.Role;
import com.example.dms.service.RoleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/role")
public class RoleController {

    private final RoleService roleService;

    public RoleController(final RoleService roleService) {
        this.roleService = Objects.requireNonNull(roleService, "roleService cannot be null");
    }

    @GetMapping("/roles")
    public ResponseEntity<List<Role>> getRoles() {
        return new ResponseEntity<>(roleService.getRoles(), HttpStatus.FOUND);
    }

    @PostMapping
    public ResponseEntity<Role> saveRole(@RequestBody final Role role) {
        return new ResponseEntity<>(roleService.saveRole(role), HttpStatus.CREATED);
    }
}
