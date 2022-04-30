package com.example.dms.rest;

import com.example.dms.security.User;
import com.example.dms.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(final UserService userService) {
        this.userService = Objects.requireNonNull(userService, "userService cannot be null");
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
        return new ResponseEntity<>(userService.getUsers(), HttpStatus.FOUND);
    }

    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody final User user) {
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
    }
}

