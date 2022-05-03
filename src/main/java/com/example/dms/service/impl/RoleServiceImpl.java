package com.example.dms.service.impl;

import com.example.dms.dao.RoleRepository;
import com.example.dms.model.RoleEntity;
import com.example.dms.service.RoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(final RoleRepository roleRepository) {
        this.roleRepository = Objects.requireNonNull(roleRepository, "roleRepository cannot be null");
    }

    @Override
    public RoleEntity saveRole(final RoleEntity roleEntity) {
        return roleRepository.save(roleEntity);
    }

    @Override
    public List<RoleEntity> getRoles() {
        return roleRepository.findAll();
    }
}
