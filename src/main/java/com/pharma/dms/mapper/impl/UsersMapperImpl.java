package com.pharma.dms.mapper.impl;

import com.pharma.dms.dto.UsersRequest;
import com.pharma.dms.dto.UsersResponse;
import com.pharma.dms.mapper.UsersMapper;
import com.pharma.dms.model.UsersEntity;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UsersMapperImpl implements UsersMapper {
    @Override
    public UsersEntity dtoToEntity(final @NotNull UsersRequest usersRequest) {
        final UsersEntity usersEntity = new UsersEntity();
        usersEntity.setName(usersRequest.getName());
        usersEntity.setUsername(usersRequest.getUsername());
        usersEntity.setPassword(usersRequest.getPassword());
        return usersEntity;
    }

    @Override
    public UsersResponse entityToDto(final @NotNull UsersEntity saveUsersEntity) {
        final UsersResponse usersResponse = new UsersResponse();
        usersResponse.setId(saveUsersEntity.getId());
        usersResponse.setName(saveUsersEntity.getName());
        usersResponse.setUsername(saveUsersEntity.getUsername());
        usersResponse.setPassword(saveUsersEntity.getPassword());
        usersResponse.setCreatedAt(saveUsersEntity.getCreatedAt());
        usersResponse.setRoles(saveUsersEntity.getRoles());
        return usersResponse;
    }

    @Override
    public List<UsersResponse> entitiesToDto(final @NotNull List<UsersEntity> usersEntityList) {
        return usersEntityList.stream().map(this::entityToDto).collect(Collectors.toList());
    }
}
