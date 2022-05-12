package com.example.dms.mapper.impl;

import com.example.dms.dto.RoleRequest;
import com.example.dms.dto.RoleResponse;
import com.example.dms.mapper.RoleMapper;
import com.example.dms.model.RoleEntity;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RoleMapperImpl implements RoleMapper {
    @Override
    public RoleEntity dtoToEntity(final @NotNull RoleRequest roleRequest) {
        final RoleEntity roleEntity = new RoleEntity();
        roleEntity.setName(roleRequest.getName());
        return roleEntity;
    }

    @Override
    public RoleResponse entityToDto(final @NotNull RoleEntity saveRoleEntity) {
        final RoleResponse roleResponse = new RoleResponse();
        roleResponse.setId(saveRoleEntity.getId());
        roleResponse.setName(saveRoleEntity.getName());
        return roleResponse;
    }

    @Override
    public List<RoleResponse> entitiesToDto(final @NotNull List<RoleEntity> roleEntityList) {
        final List<RoleResponse> roleResponses = new ArrayList<>();
        for (RoleEntity roleEntity : roleEntityList) {
            roleResponses.add(entityToDto(roleEntity));
        }
        return roleResponses;
    }
}
