package com.example.dms.mapper;

import com.example.dms.dto.RolesRequest;
import com.example.dms.dto.RolesResponse;
import com.example.dms.model.RolesEntity;

import java.util.List;

public interface RolesMapper {
    RolesEntity dtoToEntity(final RolesRequest rolesRequest);

    RolesResponse entityToDto(final RolesEntity saveRolesEntity);

    List<RolesResponse> entitiesToDto(final List<RolesEntity> rolesEntityList);
}
