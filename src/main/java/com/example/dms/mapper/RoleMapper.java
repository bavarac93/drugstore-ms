package com.example.dms.mapper;

import com.example.dms.dto.RoleRequest;
import com.example.dms.dto.RoleResponse;
import com.example.dms.model.RoleEntity;

import java.util.List;

public interface RoleMapper {
    RoleEntity dtoToEntity(final RoleRequest roleRequest);

    RoleResponse entityToDto(final RoleEntity saveRoleEntity);

    List<RoleResponse> entitiesToDto(final List<RoleEntity> roleEntityList);
}
