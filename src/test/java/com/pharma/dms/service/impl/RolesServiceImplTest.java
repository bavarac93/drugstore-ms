package com.pharma.dms.service.impl;

import com.pharma.dms.dao.RolesRepository;
import com.pharma.dms.mapper.RolesMapper;
import com.pharma.dms.mapper.impl.RolesMapperImpl;
import com.pharma.dms.service.RolesService;
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
    void canCreateRoles() {
    }

    @Test
    @Disabled
    void canFindAllRolesByName() {
    }

    @Test
    @Disabled
    void canDeleteById() {
    }
}