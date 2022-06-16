package com.example.dms.mapper.impl;

import com.example.dms.dto.RolesRequest;
import com.example.dms.dto.RolesResponse;
import com.example.dms.mapper.RolesMapper;
import com.example.dms.model.RolesEntity;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RolesMapperImpl implements RolesMapper {
    @Override
    public RolesEntity dtoToEntity(final @NotNull RolesRequest rolesRequest) {
        final RolesEntity rolesEntity = new RolesEntity();
        rolesEntity.setName(rolesRequest.getName());
        return rolesEntity;
    }

    @Override
    public RolesResponse entityToDto(final @NotNull RolesEntity saveRolesEntity) {
        final RolesResponse rolesResponse = new RolesResponse();
        rolesResponse.setId(saveRolesEntity.getId());
        rolesResponse.setName(saveRolesEntity.getName());
        return rolesResponse;
    }

    @Override
    public List<RolesResponse> entitiesToDto(final @NotNull List<RolesEntity> rolesEntityList) {
        return rolesEntityList.stream().map(this::entityToDto).collect(Collectors.toList());
    }
}
