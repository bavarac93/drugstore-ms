package com.example.dms.service.impl;

import com.example.dms.dao.RolesRepository;
import com.example.dms.dao.UsersRepository;
import com.example.dms.dto.UsersRequest;
import com.example.dms.dto.UsersResponse;
import com.example.dms.exception.ApiRequestException;
import com.example.dms.mapper.UsersMapper;
import com.example.dms.model.RolesEntity;
import com.example.dms.model.UsersEntity;
import com.example.dms.service.UsersService;
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
public class UsersServiceImpl implements UsersService, UserDetailsService {

    private static final String USER_DOES_NOT_EXIST_ID = "User with this id: {0} does not exist.";
    private static final String USER_ALREADY_EXISTS = "User with this username: {0} already exists.";
    private static final String USERNAME_DOES_NOT_EXIST = "Username {0} does not exist.";
    private static final String USER_DOES_NOT_EXIST = "User {0} does not exist.";


    private static final String AUTHOR = "Muki";

    private final UsersRepository usersRepository;
    private final RolesRepository rolesRepository;
    private final PasswordEncoder passwordEncoder;
    private final UsersMapper usersMapper;

    public UsersServiceImpl(
            final UsersRepository usersRepository,
            final RolesRepository rolesRepository,
            final PasswordEncoder passwordEncoder,
            final UsersMapper usersMapper)
    {
        this.usersRepository = Objects.requireNonNull(usersRepository, "usersRepository cannot be null");
        this.rolesRepository = Objects.requireNonNull(rolesRepository, "rolesRepository cannot be null");
        this.passwordEncoder = Objects.requireNonNull(passwordEncoder, "passwordEncoder cannot be null");
        this.usersMapper = Objects.requireNonNull(usersMapper, "usersMapper cannot be null");
    }
    private boolean userExists(final String username) {
        return usersRepository.findByUsername(username) != null;
    }

    @Override
    public UsersResponse create(final @NotNull UsersRequest usersRequest) {
        usersRequest.setPassword(passwordEncoder.encode(usersRequest.getPassword()));
        UsersEntity usersEntity = usersMapper.dtoToEntity(usersRequest);
        if (userExists(usersRequest.getUsername())) {
            throw new ApiRequestException(MessageFormat.format(USER_ALREADY_EXISTS, usersRequest.getUsername()));
        }
        usersEntity.setCreatedAt(LocalDateTime.now());
        usersEntity.setCreatedBy(AUTHOR);
        usersRequest.setPassword(passwordEncoder.encode(usersRequest.getPassword()));
        final UsersEntity saveUsersEntity = usersRepository.save(usersEntity);
        return usersMapper.entityToDto(saveUsersEntity);
    }

    @Override
    public void addRoleToUser(final String username, final String roleName) {
        final UsersEntity usersEntity = usersRepository.findByUsername(username);
        final RolesEntity rolesEntity = rolesRepository.findByName(roleName);
        usersEntity.getRoles().add(rolesEntity);
    }

    @Override
    public UsersResponse findUserByUsername(final String username) {
        final UsersEntity usersEntity = usersRepository.findByUsername(username);
        if ((usersEntity == null) || !(usersEntity.getUsername().equals(username))) {
            throw new ApiRequestException(MessageFormat.format(USERNAME_DOES_NOT_EXIST, username));
        }
        return usersMapper.entityToDto(usersEntity);
    }

    @Override
    public List<UsersResponse> findAll() {
        List<UsersEntity> usersEntityList = usersRepository.findAll();
        return usersMapper.entitiesToDto(usersEntityList);
    }

    @Override
    public void deleteById(final Long id) {
        if (!usersRepository.existsById(id)) {
            throw new ApiRequestException(
                    MessageFormat.format(USER_DOES_NOT_EXIST_ID, id));
        }
        usersRepository.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(final String username) throws ApiRequestException {
        UsersEntity user = usersRepository.findByUsername(username);
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
