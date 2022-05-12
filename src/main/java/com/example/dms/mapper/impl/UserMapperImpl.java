package com.example.dms.mapper.impl;

import com.example.dms.dto.UserRequest;
import com.example.dms.dto.UserResponse;
import com.example.dms.mapper.UserMapper;
import com.example.dms.model.UserEntity;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapperImpl implements UserMapper {
    @Override
    public UserEntity dtoToEntity(final @NotNull UserRequest userRequest) {
        final UserEntity userEntity = new UserEntity();
        userEntity.setName(userRequest.getName());
        userEntity.setUsername(userRequest.getUsername());
        userEntity.setPassword(userRequest.getPassword());
        return userEntity;
    }

    @Override
    public UserResponse entityToDto(final @NotNull UserEntity saveUserEntity) {
        final UserResponse userResponse = new UserResponse();
        userResponse.setId(saveUserEntity.getId());
        userResponse.setName(saveUserEntity.getName());
        userResponse.setUsername(saveUserEntity.getUsername());
        userResponse.setPassword(saveUserEntity.getPassword());
        userResponse.setCreatedAt(saveUserEntity.getCreatedAt());
        return userResponse;
    }

    @Override
    public List<UserResponse> entitiesToDto(final @NotNull List<UserEntity> userEntityList) {
        final List<UserResponse> userResponses = new ArrayList<>();
        for (UserEntity userEntity : userEntityList) {
            userResponses.add(entityToDto(userEntity));
        }
        return userResponses;
    }
}
