package com.example.dms.service;

import com.example.dms.model.UserEntity;

import java.util.List;

public interface UserService {

    UserEntity create (final UserEntity userEntity);

    void addRoleToUser(final String username, final String roleName);

    UserEntity getUser(final String username);

    List<UserEntity> getUsers();
}
