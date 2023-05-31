package com.pharma.dms.mapper;

import com.pharma.dms.dto.UsersRequest;
import com.pharma.dms.dto.UsersResponse;
import com.pharma.dms.model.UsersEntity;

import java.util.List;

public interface UsersMapper {
    UsersEntity dtoToEntity(final UsersRequest usersRequest);

    UsersResponse entityToDto(final UsersEntity saveUsersEntity);

    List<UsersResponse> entitiesToDto(final List<UsersEntity> usersEntityList);
}
