package com.example.dms.service;

import com.example.dms.dto.UserRequest;
import com.example.dms.dto.UserResponse;

import java.util.List;

public interface UserService {

    UserResponse create (final UserRequest userRequest);

    void addRoleToUser(final String username, final String roleName);

    UserResponse getUser(final String username);

    List<UserResponse> getUsers();
}
