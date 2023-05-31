package com.pharma.dms.mapper;

import com.pharma.dms.dto.RolesRequest;
import com.pharma.dms.dto.RolesResponse;
import com.pharma.dms.model.RolesEntity;

import java.util.List;

public interface RolesMapper {
    RolesEntity dtoToEntity(final RolesRequest rolesRequest);

    RolesResponse entityToDto(final RolesEntity saveRolesEntity);

    List<RolesResponse> entitiesToDto(final List<RolesEntity> rolesEntityList);
}
