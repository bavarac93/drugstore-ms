package com.example.dms.service;

import com.example.dms.security.Role;

import java.util.List;

public interface RoleService {

    Role saveRole(final Role role);

    List<Role> getRoles();
}
