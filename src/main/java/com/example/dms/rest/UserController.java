package com.example.dms.rest;

import com.example.dms.model.UserEntity;
import com.example.dms.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserController(final UserService userService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userService = Objects.requireNonNull(userService, "userService cannot be null");
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserEntity>> getUsers() {
        return new ResponseEntity<>(userService.getUsers(), HttpStatus.FOUND);
    }

    @PostMapping
    public ResponseEntity<UserEntity> saveUser(@RequestBody final UserEntity userEntity) {
        return new ResponseEntity<>(userService.saveUser(userEntity), HttpStatus.CREATED);
    }
}

