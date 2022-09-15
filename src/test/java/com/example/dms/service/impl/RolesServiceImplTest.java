package com.example.dms.service.impl;

import com.example.dms.dao.RolesRepository;
import com.example.dms.mapper.RolesMapper;
import com.example.dms.mapper.impl.RolesMapperImpl;
import com.example.dms.service.RolesService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
@ExtendWith(MockitoExtension.class)

class RolesServiceImplTest {
    @Mock
    private RolesRepository rolesRepository;
    private RolesService underTest;
    private RolesMapper mapper = new RolesMapperImpl();

    @BeforeEach
    void setUp() {
        underTest = new RolesServiceImpl(rolesRepository, mapper);
    }

    @Test
    void canFindAll() {
        //when
        underTest.findAll();
        //then
        verify(rolesRepository, times(1)).findAll();
    }

    @Test
    @Disabled
    void create() {
    }

    @Test
    @Disabled
    void findAllRolesByName() {
    }

    @Test
    @Disabled
    void deleteById() {
    }
}