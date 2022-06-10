package com.example.dms.mapper;

import com.example.dms.dto.UsersRequest;
import com.example.dms.dto.UsersResponse;
import com.example.dms.model.UsersEntity;

import java.util.List;

public interface UsersMapper {
    UsersEntity dtoToEntity(final UsersRequest usersRequest);

    UsersResponse entityToDto(final UsersEntity saveUsersEntity);

    List<UsersResponse> entitiesToDto(final List<UsersEntity> usersEntityList);
}
