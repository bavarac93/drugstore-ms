package com.pharma.dms.service.impl;

import com.pharma.dms.dao.RolesRepository;
import com.pharma.dms.dao.UsersRepository;
import com.pharma.dms.mapper.UsersMapper;
import com.pharma.dms.mapper.impl.UsersMapperImpl;
import com.pharma.dms.service.UsersService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class UsersServiceImplTest {
    @Mock
    private UsersRepository usersRepository;
    private UsersService underTest;
    private UsersMapper mapper = new UsersMapperImpl();

    @Mock private RolesRepository rolesRepository;
    @Mock private PasswordEncoder passwordEncoder;

    @BeforeEach
    void setUp() {
        underTest = new UsersServiceImpl(usersRepository, rolesRepository, passwordEncoder, mapper);
    }

    @Test
    void canFindAllUsers() {
        //when
        underTest.findAll();
        //then
        verify(usersRepository, times(1)).findAll();
    }

    @Test
    @Disabled
    void canCreateUsers() {
    }

    @Test
    @Disabled
    void canAddRoleToUser() {
    }

    @Test
    @Disabled
    void canFindUserByUsername() {
    }

    @Test
    @Disabled
    void canDeleteById() {
    }

    @Test
    @Disabled
    void canLoadUserByUsername() {
    }
}