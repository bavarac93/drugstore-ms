package com.example.dms.service.impl;

import com.example.dms.dao.RoleRepository;
import com.example.dms.dto.RoleRequest;
import com.example.dms.dto.RoleResponse;
import com.example.dms.exception.ApiRequestException;
import com.example.dms.mapper.RoleMapper;
import com.example.dms.model.RoleEntity;
import com.example.dms.service.RoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.MessageFormat;
import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;
    private static final String ROLE_DOES_NOT_EXIST = "Role with this id: {0} does not exist.";

    public RoleServiceImpl(final RoleRepository roleRepository, final RoleMapper roleMapper) {
        this.roleRepository = Objects.requireNonNull(roleRepository, "roleRepository cannot be null");
        this.roleMapper = Objects.requireNonNull(roleMapper, "roleMapper cannot be null");
    }

    @Override
    public RoleResponse create(final RoleRequest roleRequest) {
        final RoleEntity roleEntity = roleMapper.dtoToEntity(roleRequest);
        final RoleEntity saveRoleEntity = roleRepository.save(roleEntity);
        return roleMapper.entityToDto(saveRoleEntity);
    }

    @Override
    public List<RoleResponse> findAll() {
        List<RoleEntity> roleEntityList = roleRepository.findAll();
        return roleMapper.entitiesToDto(roleEntityList);
    }

    @Override
    public void deleteById(final Long id) {
        if (!roleRepository.existsById(id)) {
            throw new ApiRequestException(
                    MessageFormat.format(ROLE_DOES_NOT_EXIST, id));
        }
        roleRepository.deleteById(id);
    }
}
