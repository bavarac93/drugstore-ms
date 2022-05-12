package com.example.dms.mapper;

import com.example.dms.dto.UserRequest;
import com.example.dms.dto.UserResponse;
import com.example.dms.model.UserEntity;

import java.util.List;

public interface UserMapper {
    UserEntity dtoToEntity(final UserRequest userRequest);

    UserResponse entityToDto(final UserEntity saveUserEntity);

    List<UserResponse> entitiesToDto(final List<UserEntity> userEntityList);
}
