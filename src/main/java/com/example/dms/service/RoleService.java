package com.example.dms.service;

import com.example.dms.model.RoleEntity;

import java.util.List;

public interface RoleService {

    RoleEntity create (final RoleEntity roleEntity);

    List<RoleEntity> getRoles();
}
