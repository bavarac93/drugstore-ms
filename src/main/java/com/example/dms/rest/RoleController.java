package com.example.dms.rest;

import com.example.dms.model.RoleEntity;
import com.example.dms.service.RoleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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
    public ResponseEntity<List<RoleEntity>> getRoles() {
        return new ResponseEntity<>(roleService.getRoles(), HttpStatus.FOUND);
    }

    @PostMapping
    public ResponseEntity<RoleEntity> create (@RequestBody RoleEntity role) {
        return new ResponseEntity<>(roleService.create(role), HttpStatus.CREATED);
    }
}
