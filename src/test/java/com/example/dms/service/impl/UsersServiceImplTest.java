package com.example.dms.service.impl;

import com.example.dms.dao.RolesRepository;
import com.example.dms.dao.UsersRepository;
import com.example.dms.mapper.UsersMapper;
import com.example.dms.mapper.impl.UsersMapperImpl;
import com.example.dms.service.UsersService;
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
    void canFindAll() {
        //when
        underTest.findAll();
        //then
        verify(usersRepository, times(1)).findAll();
    }

    @Test
    @Disabled
    void create() {
    }

    @Test
    @Disabled
    void addRoleToUser() {
    }

    @Test
    @Disabled
    void findUserByUsername() {
    }

    @Test
    @Disabled
    void deleteById() {
    }

    @Test
    @Disabled
    void loadUserByUsername() {
    }
}