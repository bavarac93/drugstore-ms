package com.example.dms.service.impl;

import com.example.dms.dao.RoleRepository;
import com.example.dms.dao.UserRepository;
import com.example.dms.dto.UserRequest;
import com.example.dms.dto.UserResponse;
import com.example.dms.exception.ApiRequestException;
import com.example.dms.mapper.UserMapper;
import com.example.dms.model.RoleEntity;
import com.example.dms.model.UserEntity;
import com.example.dms.service.UserService;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class UserServiceImpl implements UserService, UserDetailsService {

    private static final String USER_DOES_NOT_EXIST_ID = "User with this id: {0} does not exist.";
    private static final String USER_ALREADY_EXISTS = "User with this username: {0} already exists.";
    private static final String USERNAME_DOES_NOT_EXIST = "Username {0} does not exist.";
    private static final String USER_DOES_NOT_EXIST = "User {0} does not exist.";


    private static final String AUTHOR = "Muki";

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    public UserServiceImpl(
            final UserRepository userRepository,
            final RoleRepository roleRepository,
            final PasswordEncoder passwordEncoder,
            final UserMapper userMapper)
    {
        this.userRepository = Objects.requireNonNull(userRepository, "userRepository cannot be null");
        this.roleRepository = Objects.requireNonNull(roleRepository, "roleRepository cannot be null");
        this.passwordEncoder = Objects.requireNonNull(passwordEncoder, "passwordEncoder cannot be null");
        this.userMapper = Objects.requireNonNull(userMapper, "userMapper cannot be null");
    }
    private boolean userExists(final String username) {
        return userRepository.findByUsername(username) != null;
    }

    @Override
    public UserResponse create(final @NotNull UserRequest userRequest) {
        userRequest.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        UserEntity userEntity = userMapper.dtoToEntity(userRequest);
        if (userExists(userRequest.getUsername())) {
            throw new ApiRequestException(MessageFormat.format(USER_ALREADY_EXISTS,userRequest.getUsername()));
        }
        userEntity.setCreatedAt(LocalDateTime.now());
        userEntity.setCreatedBy(AUTHOR);
        userRequest.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        final UserEntity saveUserEntity = userRepository.save(userEntity);
        return userMapper.entityToDto(saveUserEntity);
    }

    @Override
    public void addRoleToUser(final String username, final String roleName) {
        final UserEntity userEntity = userRepository.findByUsername(username);
        final RoleEntity roleEntity = roleRepository.findByName(roleName);
        userEntity.getRoles().add(roleEntity);
    }

    @Override
    public UserResponse findUserByUsername(final String username) {
        final UserEntity userEntity = userRepository.findByUsername(username);
        if ((userEntity == null) || !(userEntity.getUsername().equals(username))) {
            throw new ApiRequestException(MessageFormat.format(USERNAME_DOES_NOT_EXIST, username));
        }
        return userMapper.entityToDto(userEntity);
    }

    @Override
    public List<UserResponse> findAll() {
        List<UserEntity> userEntityList = userRepository.findAll();
        return userMapper.entitiesToDto(userEntityList);
    }

    @Override
    public void deleteById(final Long id) {
        if (!userRepository.existsById(id)) {
            throw new ApiRequestException(
                    MessageFormat.format(USER_DOES_NOT_EXIST_ID, id));
        }
        userRepository.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(final String username) throws ApiRequestException {
        UserEntity user = userRepository.findByUsername(username);
        if (user == null) {
            throw new ApiRequestException(MessageFormat.format(USER_DOES_NOT_EXIST, username));
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(roleEntity -> {
            authorities.add((new SimpleGrantedAuthority(roleEntity.getName())));
        });
        return new User(user.getUsername(), user.getPassword(), authorities);
    }
}
