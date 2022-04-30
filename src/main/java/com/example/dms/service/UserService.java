package com.example.dms.service;

import com.example.dms.security.User;

import java.util.List;

public interface UserService {

    User saveUser(final User user);

    void addRoleToUser(final String username, final String roleName);

    User getUser(final String username);

    List<User> getUsers();
}
